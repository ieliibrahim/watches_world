package com.ieli.ww.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ieli.ww.model.product.Product;
import com.ieli.ww.model.product.costs.CostDetails;
import com.ieli.ww.model.product.costs.CostDetailsCurrency;
import com.ieli.ww.repository.product.ProductRepository;
import com.ieli.ww.util.DateUtil;
import com.ieli.ww.util.StaticData;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct(Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			model.addAttribute("username", getPrincipal());
			Product product = new Product();

			CostDetails costDetails = new CostDetails();
			List<CostDetailsCurrency> costDetailsCurrencies = new ArrayList<CostDetailsCurrency>();

			CostDetailsCurrency costDetailsCurrencyEuro = new CostDetailsCurrency();
			costDetailsCurrencyEuro.setCost(new Double(0.0));
			costDetailsCurrencies.add(costDetailsCurrencyEuro);

			CostDetailsCurrency costDetailsCurrencyPound = new CostDetailsCurrency();
			costDetailsCurrencyPound.setCost(new Double(0.0));
			costDetailsCurrencies.add(costDetailsCurrencyPound);

			CostDetailsCurrency costDetailsCurrencyUSD = new CostDetailsCurrency();
			costDetailsCurrencyUSD.setCost(new Double(0.0));
			costDetailsCurrencies.add(costDetailsCurrencyUSD);

			costDetails.setCostDetailsCurrencies(costDetailsCurrencies);

			product.setCostDetails(costDetails);

			model.addAttribute("product", product);
		}
		return new ModelAndView("admin/addProduct");
	}

	@RequestMapping(value = { "/saveProduct" }, method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveUser(@ModelAttribute("product") Product product,
			@RequestParam(name = "file", required = false) MultipartFile image, BindingResult result, Model model) {

		String month = StaticData.FULL_MONTH_NAME;

		product.setEnabled(true);
		product.setMonth(month);

		if (product.getCostDetails() != null) {

			product.getCostDetails().setEnabled(true);
			product.getCostDetails().setMonth(month);
			
			List<CostDetailsCurrency> costDetailsCurrencies = product.getCostDetails().getCostDetailsCurrencies();
			costDetailsCurrencies.get(0).setCurrency("Euro");
			costDetailsCurrencies.get(0).setEnabled(true);
			
			costDetailsCurrencies.get(1).setCurrency("Pound");
			costDetailsCurrencies.get(1).setEnabled(true);
			
			costDetailsCurrencies.get(2).setCurrency("USD");
			costDetailsCurrencies.get(2).setEnabled(true);
		}

		String dateAddedModified = DateUtil.getMySQLDate();
		product.setDateAdded(dateAddedModified);
		product.setDateModified(dateAddedModified);
		product.setDateSold(dateAddedModified);

		Product dbProduct = productRepository.save(product);

		if (image != null) {
			try {
				File rootPath = new File(System.getProperty("catalina.home") + File.separator + "webapps"
						+ File.separator + "ww_resources" + File.separator + "products");
				if (!rootPath.exists()) {
					rootPath.mkdirs();
				}

				byte[] imageBytes = image.getBytes();

				File serverOriginalFile = new File(
						rootPath + File.separator + dbProduct.getProductId() + "_" + new Date().getTime() + "_.png");

				FileOutputStream fosOrig = new FileOutputStream(serverOriginalFile);
				fosOrig.write(imageBytes);
				fosOrig.close();

				String dbPath = StaticData.SERVER_API_PATH + "ww_resources/products/";
				dbProduct.setImagePath(dbPath + serverOriginalFile.getName());

				productRepository.saveAndFlush(dbProduct);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/admin/adminboard";
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
