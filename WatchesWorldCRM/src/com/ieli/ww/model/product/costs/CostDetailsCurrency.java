package com.ieli.ww.model.product.costs;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cost_details_currency")
public class CostDetailsCurrency implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long costDetailsCurrencyId;
	private Double rrp;
	private String currency;
	private Double extraCost;
	private Double sellingPrice;
	private Double actuallySold;
	private Double profit;
	private Double profitPercentage;
	private boolean enabled;
	private Long costDetailsId;

	public CostDetailsCurrency() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cost_details_currency_id", unique = true, nullable = false)
	public Long getCostDetailsCurrencyId() {
		return costDetailsCurrencyId;
	}

	public void setCostDetailsCurrencyId(Long costDetailsCurrencyId) {
		this.costDetailsCurrencyId = costDetailsCurrencyId;
	}

	@Column(name = "cost_details_id", nullable = false)
	public Long getCostDetailsId() {
		return costDetailsId;
	}

	public void setCostDetailsId(Long costDetailsId) {
		this.costDetailsId = costDetailsId;
	}

	@Column(name = "rrp")
	public Double getRrp() {
		return rrp;
	}

	public void setRrp(Double rrp) {
		this.rrp = rrp;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "extra_cost")
	public Double getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(Double extraCost) {
		this.extraCost = extraCost;
	}

	@Column(name = "selling_price")
	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Column(name = "actually_sold")
	public Double getActuallySold() {
		return actuallySold;
	}

	public void setActuallySold(Double actuallySold) {
		this.actuallySold = actuallySold;
	}

	@Column(name = "profit")
	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	@Column(name = "profit_percentage")
	public Double getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(Double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
