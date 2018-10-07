package com.ieli.ww.controller;

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

import com.ieli.ww.model.product.Product;
import com.ieli.ww.repository.product.ProductRepository;
import com.ieli.ww.service.config.products.costs.ICostsService;
import com.ieli.ww.util.StaticData;

@Controller
@RequestMapping("/admin")
public class MainBoardController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ICostsService iCostsService;

	@RequestMapping(value = "/adminboard", method = RequestMethod.GET)
	public String adminboard(Pageable pageable, Model model) {

		String month = StaticData.FULL_MONTH_NAME;

		Page<Product> products = productRepository.findAllByEnabled(true, new PageRequest(0, 10));

		setupSold(model, month);

		setupTotalCosts(model, month);

		model.addAttribute("username", getPrincipal());

		model.addAttribute("products", products.getContent());
		return "admin/adminboard";
	}

	private void setupSold(Model model, String month) {
		Long totalRecords = productRepository.countByEnabled(true);

		Long soldFemaleCount = productRepository.countByClientGenderAndMonthAndEnabled("Female", month, true);
		Long soldPercFemale = ((soldFemaleCount * 100) / totalRecords);

		model.addAttribute("soldFemale", soldFemaleCount);
		model.addAttribute("soldFemalePerc", soldPercFemale);

		Long soldMaleCount = productRepository.countByClientGenderAndMonthAndEnabled("Male", month, true);
		Long soldPercMale = ((soldMaleCount * 100) / totalRecords);

		model.addAttribute("soldMale", soldMaleCount);
		model.addAttribute("soldMalePerc", soldPercMale);
	}

	private void setupTotalCosts(Model model, String month) {

		model.addAttribute("profitEuro", iCostsService.getCostsForCurrency("Euro", month, true));

		model.addAttribute("profitUSD", iCostsService.getCostsForCurrency("USD", month, true));

		model.addAttribute("profitPound", iCostsService.getCostsForCurrency("Pound", month, true));

		model.addAttribute("month", month);
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
