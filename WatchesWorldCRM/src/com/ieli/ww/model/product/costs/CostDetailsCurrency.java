package com.ieli.ww.model.product.costs;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cost_details_currency")
public class CostDetailsCurrency implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long costDetailsCurrencyId;
	private String rrp;
	private String currency;
	private String cost;
	private String extraCost;
	private String sellingPrice;
	private String actuallySold;
	private String profit;
	private String profitPercentage;
	private boolean enabled;
	private CostDetails costDetails;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cost_details_id", nullable = false)
	@JsonBackReference
	public CostDetails getCostDetails() {
		return costDetails;
	}

	public void setCostDetails(CostDetails costDetails) {
		this.costDetails = costDetails;
	}

	@Column(name = "rrp")
	public String getRrp() {
		return rrp;
	}

	public void setRrp(String rrp) {
		this.rrp = rrp;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "cost")
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Column(name = "extra_cost")
	public String getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(String extraCost) {
		this.extraCost = extraCost;
	}

	@Column(name = "selling_price")
	public String getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Column(name = "actually_sold")
	public String getActuallySold() {
		return actuallySold;
	}

	public void setActuallySold(String actuallySold) {
		this.actuallySold = actuallySold;
	}

	@Column(name = "profit")
	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	@Column(name = "profit_percentage")
	public String getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(String profitPercentage) {
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
