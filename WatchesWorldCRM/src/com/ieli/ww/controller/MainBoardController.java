package com.ieli.ww.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ieli.ww.model.product.costs.CostDetails;
import com.ieli.ww.model.user.User;
import com.ieli.ww.repository.product.clients.ClientsRepository;
import com.ieli.ww.repository.product.costs.CostsRepository;
import com.ieli.ww.repository.user.UserRepository;
import com.ieli.ww.util.StaticData;

@Controller
@RequestMapping("/admin")
public class MainBoardController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CostsRepository costsRepository;

	@Autowired
	private ClientsRepository clientsRepository;

	@RequestMapping(value = "/adminboard", method = RequestMethod.GET)
	public String adminboard(Pageable pageable, Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			UserDetails loggedInUser = (UserDetails) principal;
			User user = userRepository.findByUsername(loggedInUser.getUsername());

			setupTotalCosts(model);

			setupSold(model);

			model.addAttribute("user", user);

		}
		return "admin/adminboard";
	}

	private void setupSold(Model model) {
		Long clientsCount = clientsRepository.count();

		Long soldFemale = clientsRepository.countByGenderAndEnabled("Female", true);
		Long soldFemalePerc = (soldFemale * 100) / clientsCount;

		model.addAttribute("soldFemale", soldFemale);
		model.addAttribute("soldFemalePerc", soldFemalePerc);

		Long soldMale = clientsRepository.countByGenderAndEnabled("Male", true);
		Long soldMalePerc = (soldMale * 100) / clientsCount;

		model.addAttribute("soldMale", soldMale);
		model.addAttribute("soldMalePerc", soldMalePerc);
	}

	private void setupTotalCosts(Model model) {
		String month = StaticData.FULL_MONTH_NAME;

		List<CostDetails> euroCostDetails = costsRepository.getCostDetailsByCurrencyAndMonthAndEnabled("Euro", month,
				true);

		model.addAttribute("profitEuro", getSum(euroCostDetails, StaticData.EURO_NUM_FORMAT));

		List<CostDetails> usdCostDetails = costsRepository.getCostDetailsByCurrencyAndMonthAndEnabled("USD", month,
				true);

		model.addAttribute("profitUSD", getSum(usdCostDetails, StaticData.USD_NUM_FORMAT));

		List<CostDetails> pondCostDetails = costsRepository.getCostDetailsByCurrencyAndMonthAndEnabled("Pound", month,
				true);

		model.addAttribute("profitPound", getSum(pondCostDetails, StaticData.POUND_NUM_FORMAT));

		model.addAttribute("month", month);
	}

	private String getSum(List<CostDetails> costDetailsList, NumberFormat numberFormat) {

		BigDecimal profit = new BigDecimal(0.0);
		if (!costDetailsList.isEmpty()) {
			for (CostDetails costDetails : costDetailsList) {
				profit = profit.add(new BigDecimal(costDetails.getProfit()));
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
