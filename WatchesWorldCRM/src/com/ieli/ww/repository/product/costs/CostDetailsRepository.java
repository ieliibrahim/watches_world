package com.ieli.ww.repository.product.costs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.costs.CostDetails;

@Repository("costDetailsRepository")
@Transactional
public interface CostDetailsRepository extends JpaRepository<CostDetails, Long> {

	List<CostDetails> getCostDetailsByProductMonthAndProductIsStockAndEnabled(String month, boolean isStock,
			boolean enabled);

}
