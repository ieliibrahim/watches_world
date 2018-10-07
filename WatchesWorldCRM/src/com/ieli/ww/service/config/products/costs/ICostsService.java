package com.ieli.ww.service.config.products.costs;

import java.util.List;

public interface ICostsService {

	String getCostsForCurrency(String currency, String month, boolean enabled);

	List<Long> getCountsByGender(String gender, String month, boolean enabled);
}
