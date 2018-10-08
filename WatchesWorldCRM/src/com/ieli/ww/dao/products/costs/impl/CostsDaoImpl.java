package com.ieli.ww.dao.products.costs.impl;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.ieli.ww.dao.products.costs.ICostsDao;
import com.ieli.ww.dao.util.GeneralDao;
import com.ieli.ww.util.StackTraceHandler;

@Repository("iCostsDao")
public class CostsDaoImpl extends GeneralDao implements ICostsDao {

	private static Logger daoLogger = Logger.getLogger(CostsDaoImpl.class);

	@Override
	public Double getCostsForCurrency(String currency, String month, boolean enabled) {

		Double cost = 0.0;
		try {
			String sql = "select sum(co_det_cur.profit) as euro_profit from cost_details co_det inner join "
					+ "cost_details_currency co_det_cur on co_det.cost_details_id = co_det_cur.cost_details_id "
					+ "where co_det.enabled = 1 and co_det_cur.enabled = " + enabled + " and co_det_cur.currency = '"
					+ currency + "' and product_month = '" + month + "';";
			SQLQuery query = getSession().createSQLQuery(sql);
			cost = (Double) query.uniqueResult();

		} catch (

		Exception e) {
			daoLogger.error(StackTraceHandler.getErrString(e));
		}
		return cost;
	}

}
