package com.ieli.ww.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ieli.ww.model.datatables.DataTableRequest;
import com.ieli.ww.model.datatables.DataTableResults;
import com.ieli.ww.model.datatables.PaginationCriteria;
import com.ieli.ww.model.product.Product;
import com.ieli.ww.model.product.costs.CostDetails;
import com.ieli.ww.model.product.costs.CostDetailsCurrency;
import com.ieli.ww.model.user.User;
import com.ieli.ww.repository.product.ProductRepository;
import com.ieli.ww.repository.product.clients.ClientsRepository;
import com.ieli.ww.repository.product.costs.CostDetailsCurrencyRepository;
import com.ieli.ww.repository.product.costs.CostDetailsRepository;
import com.ieli.ww.repository.user.UserRepository;
import com.ieli.ww.util.DataTablesUtil;
import com.ieli.ww.util.StaticData;

@Controller
@RequestMapping("/admin")
public class MainBoardController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CostDetailsRepository costDetailsRepository;

	@Autowired
	private CostDetailsCurrencyRepository costDetailsCurrencyRepository;

	@Autowired
	private ClientsRepository clientsRepository;

	@Autowired
	private ProductRepository productRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping(value = "/adminboard", method = RequestMethod.GET)
	public String adminboard(Pageable pageable, Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			UserDetails loggedInUser = (UserDetails) principal;
			User user = userRepository.findByUsername(loggedInUser.getUsername());

			String month = StaticData.FULL_MONTH_NAME;

			setupTotalCosts(model, month);

			setupSold(model, month);

			model.addAttribute("user", user);

		}
		return "admin/adminboard";
	}

	@RequestMapping(value = "/getProductsJSON", method = RequestMethod.GET)
	@ResponseBody
	public String getJsonData(HttpServletRequest request) {

		int draw = Integer.valueOf(request.getParameter("draw"));
		// Start record
		int start = Integer.valueOf(request.getParameter("start"));

		// Numberof records that the table can display
		int length = Integer.valueOf(request.getParameter("length"));

		String searchValue = request.getParameter("search[value]");

		int pageNumber = (start + length) / length;

		Page<Product> products = null;
		if (searchValue != null && !searchValue.equals("")) {
			products = productRepository.getDataTablesRecordsWithSearch(searchValue, true,
					new PageRequest(pageNumber - 1, length));
		} else {
			products = productRepository.getDataTablesRecords(true, new PageRequest(pageNumber - 1, length));
		}

		JsonObject data = new JsonObject();
		data.addProperty("draw", draw);
		data.addProperty("recordsTotal", productRepository.countByEnabled(true));
		data.addProperty("recordsFiltered", products.getSize());

		JsonArray dataArray = new JsonArray();
		for (Product product : products.getContent()) {

			JsonObject productJson = new JsonObject();

			productJson.addProperty("productId", product.getProductId());
			productJson.addProperty("brand", product.getBrand());
			productJson.addProperty("model", product.getModel());
			productJson.addProperty("productReference", product.getProductReference());
			productJson.addProperty("year", product.getYear());
			productJson.addProperty("serial", product.getSerial());

			dataArray.add(productJson);
		}

		data.add("data", dataArray);

		return data.toString();

	}

	@RequestMapping(value = "/getProductsJSONV2", method = RequestMethod.GET)
	@ResponseBody
	public String listUsersPaginated(HttpServletRequest request, HttpServletResponse response, Model model) {

		DataTableRequest<Product> dataTableInRQ = new DataTableRequest<Product>(request);
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();

		String baseQuery = "SELECT	* from products, " + "(SELECT COUNT(1) FROM products) as total_records";

		String paginatedQuery = DataTablesUtil.buildPaginatedQuery(baseQuery, pagination);

		Query query = entityManager.createNativeQuery(paginatedQuery, Product.class);

		@SuppressWarnings("unchecked")
		List<Product> productsList = query.getResultList();

		String totalCount = String.valueOf(productRepository.countByEnabled(true));
		DataTableResults<Product> dataTableResult = new DataTableResults<Product>();
		dataTableResult.setDraw(dataTableInRQ.getDraw());
		dataTableResult.setListOfDataObjects(productsList);
		if (!DataTablesUtil.isObjectEmpty(productsList)) {

			dataTableResult.setRecordsTotal(totalCount);
			if (dataTableInRQ.getPaginationRequest().isFilterByEmpty()) {
				dataTableResult.setRecordsFiltered(totalCount);
			} else {
				dataTableResult.setRecordsFiltered(String.valueOf(productsList.size()));
			}
		}

		return new Gson().toJson(dataTableResult);
	}

	private void setupSold(Model model, String month) {
		Long clientsCount = clientsRepository.count();

		Long soldFemale = clientsRepository.countByGenderAndMonthAndEnabled("Female", month, true);
		Long soldFemalePerc = (soldFemale * 100) / clientsCount;

		model.addAttribute("soldFemale", soldFemale);
		model.addAttribute("soldFemalePerc", soldFemalePerc);

		Long soldMale = clientsRepository.countByGenderAndMonthAndEnabled("Male", month, true);
		Long soldMalePerc = (soldMale * 100) / clientsCount;

		model.addAttribute("soldMale", soldMale);
		model.addAttribute("soldMalePerc", soldMalePerc);
	}

	private void setupTotalCosts(Model model, String month) {

		List<CostDetails> euroCostDetails = costDetailsRepository.getCostDetailsByMonthAndEnabled(month, true);

		model.addAttribute("profitEuro", getSum(euroCostDetails, StaticData.EURO_NUM_FORMAT, "Euro"));

		List<CostDetails> usdCostDetails = costDetailsRepository.getCostDetailsByMonthAndEnabled(month, true);

		model.addAttribute("profitUSD", getSum(usdCostDetails, StaticData.USD_NUM_FORMAT, "USD"));

		List<CostDetails> pondCostDetails = costDetailsRepository.getCostDetailsByMonthAndEnabled(month, true);

		model.addAttribute("profitPound", getSum(pondCostDetails, StaticData.POUND_NUM_FORMAT, "Pound"));

		model.addAttribute("month", month);
	}

	private String getSum(List<CostDetails> costDetailsList, NumberFormat numberFormat, String currency) {

		BigDecimal profit = new BigDecimal(0.0);
		if (!costDetailsList.isEmpty()) {
			for (CostDetails costDetails : costDetailsList) {
				List<CostDetailsCurrency> costDetailsCurrencyList = costDetailsCurrencyRepository
						.getCostDetailsCurrencyByCostDetailsIdAndCurrencyAndEnabled(costDetails.getCostDetailsId(),
								currency, true);
				if (costDetailsCurrencyList != null) {
					for (CostDetailsCurrency costDetailsCurrency : costDetailsCurrencyList) {
						profit = profit.add(new BigDecimal(costDetailsCurrency.getProfit()));
					}
				}
			}
		}

		String profitStr = "0.0";
		try {
			profitStr = numberFormat.format(profit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profitStr;
	}
}
