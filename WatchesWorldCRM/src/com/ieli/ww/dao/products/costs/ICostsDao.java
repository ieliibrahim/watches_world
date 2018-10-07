package com.ieli.ww.dao.products.costs;

import java.math.BigDecimal;
import java.util.List;

public interface ICostsDao {

	BigDecimal getCostsForCurrency(String currency, String month, boolean enabled);
	
	List<Object[]> getCountsByGender(String gender, String month, boolean enabled);

}
