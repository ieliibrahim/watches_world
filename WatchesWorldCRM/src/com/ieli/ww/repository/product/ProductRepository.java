package com.ieli.ww.repository.product;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.Product;

@Repository("productRepository")
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Modifying
	@Query("update Product prod set prod.enabled = ?1")
	void toggleProductEnabled(Boolean enabled);

	Page<Product> findAllByEnabled(Pageable pageable, Boolean enabled);
}
