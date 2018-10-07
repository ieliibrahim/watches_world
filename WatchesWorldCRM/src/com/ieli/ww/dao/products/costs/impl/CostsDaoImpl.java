package com.ieli.ww.dao.products.costs.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	public BigDecimal getCostsForCurrency(String currency, String month, boolean enabled) {

		BigDecimal cost = new BigDecimal(0.0);
		try {
			String sql = "select sum(co_det_cur.profit) as euro_profit from cost_details co_det inner join "
					+ "cost_details_currency co_det_cur on co_det.cost_details_id = co_det_cur.cost_details_id "
					+ "where co_det.enabled = 1 and co_det_cur.enabled = " + enabled + " and co_det_cur.currency = '"
					+ currency + "' and month = '" + month + "';";
			SQLQuery query = getSession().createSQLQuery(sql);
			cost = (BigDecimal) query.uniqueResult();

		} catch (

		Exception e) {
			daoLogger.error(StackTraceHandler.getErrString(e));
		}
		return cost;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCountsByGender(String gender, String month, boolean enabled) {

		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] {0});
		data.add(new Object[] {0});

		try {
			String sql = "select (select count(*) from products) as total_records, count(1) as res from products "
					+ " where client_gender = '" + gender + "' and month = '" + month + "' and enabled = " + enabled + ";";
			SQLQuery query = getSession().createSQLQuery(sql);
			data = query.list();

		} catch (Exception e) {
			daoLogger.error(StackTraceHandler.getErrString(e));
		}

		return data;
	}

}
