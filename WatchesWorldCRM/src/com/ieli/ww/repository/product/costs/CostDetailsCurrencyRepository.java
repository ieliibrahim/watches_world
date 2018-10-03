package com.ieli.ww.repository.product.costs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.costs.CostDetailsCurrency;

@Repository("costDetailsCurrencyRepository")
@Transactional
public interface CostDetailsCurrencyRepository extends JpaRepository<CostDetailsCurrency, Long> {

	List<CostDetailsCurrency> getCostDetailsCurrencyByCostDetailsIdAndCurrencyAndEnabled(Long costDetailsId,
			String currency, Boolean enabled);

}
