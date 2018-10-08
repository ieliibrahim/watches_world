package com.ieli.ww.dao.products.costs;

public interface ICostsDao {

	Double getCostsForCurrency(String currency, String month, boolean enabled);

}
