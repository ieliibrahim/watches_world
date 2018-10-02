package com.ieli.ww.service.product;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ieli.ww.model.product.Product;
import com.ieli.ww.repository.product.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void toggleProductEnabled(Boolean enabled) {
		productRepository.toggleProductEnabled(enabled);
	}

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Page<Product> getProductsByEnabled(Pageable pageable, Boolean enabled) {
		return productRepository.findAllByEnabled(pageable, enabled);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.saveAndFlush(product);
	}

}
