package com.ieli.ww.repository.product;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.Product;

@Repository("productRepository")
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findAllByEnabled(boolean enabled, Pageable pageable);

	Long countByEnabled(boolean enabled);

	Long countByClientGenderAndProductMonthAndIsStockAndEnabled(String string, String month, boolean isStock,
			boolean enabled);
}
