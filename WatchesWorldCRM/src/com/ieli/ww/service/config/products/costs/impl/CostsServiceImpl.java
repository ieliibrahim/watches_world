package com.ieli.ww.service.config.products.costs.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieli.ww.dao.products.costs.ICostsDao;
import com.ieli.ww.service.config.products.costs.ICostsService;
import com.ieli.ww.util.StaticData;

@Service
@Transactional
public class CostsServiceImpl implements ICostsService {

	@Autowired
	private ICostsDao iCostsDao;

	@Override
	public String getCostsForCurrency(String currency, String month, boolean enabled) {

		BigDecimal profit = new BigDecimal(iCostsDao.getCostsForCurrency(currency, month, enabled));
		String profitStr = "0.0";
		try {
			profitStr = StaticData.EURO_NUM_FORMAT.format(profit);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profitStr;
	}

}
