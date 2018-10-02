package com.ieli.ww.repository.product.costs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.costs.CostDetails;

@Repository("costsRepository")
@Transactional
public interface CostsRepository extends JpaRepository<CostDetails, Long> {

	List<CostDetails> getCostDetailsByCurrencyAndMonthAndEnabled(String currency, String month, Boolean enabled);

}
