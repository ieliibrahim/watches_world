package com.ieli.ww.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ieli.ww.model.product.Product;

public interface IProductService {

	Page<Product> getAllProducts(Pageable pageable);

	Page<Product> getProductsByEnabled(Pageable pageable, Boolean enabled);

	Product addProduct(Product product);

	void updateProduct(Product product);

	/**
	 * Soft delete a product (Set toggle enabled value)
	 * 
	 * @param productId
	 *            The product ID
	 */
	void toggleProductEnabled(Boolean enabled);
}
