package com.ieli.ww.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ieli.ww.model.product.Product;
import com.ieli.ww.model.product.costs.CostDetails;
import com.ieli.ww.model.product.costs.CostDetailsCurrency;
import com.ieli.ww.model.user.User;
import com.ieli.ww.repository.product.ProductRepository;
import com.ieli.ww.repository.product.clients.ClientsRepository;
import com.ieli.ww.repository.product.costs.CostDetailsCurrencyRepository;
import com.ieli.ww.repository.product.costs.CostDetailsRepository;
import com.ieli.ww.repository.user.UserRepository;
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

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllProducts(HttpServletRequest req, HttpServletResponse resp) {
		List<Product> products = productRepository.findAllByEnabled(true);
		return products;
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
