package com.ieli.ww.service.config.products.costs.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

		BigDecimal profit = iCostsDao.getCostsForCurrency(currency, month, enabled);
		String profitStr = "0.0";
		try {
			profitStr = StaticData.EURO_NUM_FORMAT.format(profit);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profitStr;
	}

	@Override
	public List<Long> getCountsByGender(String gender, String month, boolean enabled) {

		List<Object[]> data = iCostsDao.getCountsByGender(gender, month, enabled);
		BigInteger soldCount = (BigInteger) data.get(0)[1];
		BigInteger clientsCount = (BigInteger) data.get(0)[0];

		Long soldPerc = ((soldCount.longValue() * 100) / clientsCount.longValue());

		List<Long> res = new ArrayList<Long>();
		res.add(soldCount.longValue());
		res.add(soldPerc);
		return res;
	}

}
