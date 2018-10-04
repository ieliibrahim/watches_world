package com.ieli.ww.repository.product;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.Product;

@Repository("productRepository")
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select prod from Product prod where prod.enabled = ?1")
	Page<Product> getDataTablesRecords(boolean enabled, Pageable pageable);

	@Query("select prod from Product prod where (?1 is null or prod.brand like ?1) "
			+ "or (?1 is null or prod.model like ?1) " + "or (?1 is null or prod.productReference like ?1)"
			+ "or (?1 is null or prod.year like ?1)" + "or (?1 is null or prod.year like ?1) and prod.enabled = ?2")
	Page<Product> getDataTablesRecordsWithSearch(String searchValue, boolean enabled, Pageable pageable);

	Long countByEnabled(boolean enabled);
}
