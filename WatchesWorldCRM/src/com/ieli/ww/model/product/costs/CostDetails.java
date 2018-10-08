package com.ieli.ww.model.product.costs;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ieli.ww.model.product.Product;

@Entity
@Table(name = "cost_details")
public class CostDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long costDetailsId;
	private String productMonth;
	private String extraCostDescription;
	private boolean enabled;
	private Product product;
	private String ratePound;
	private String rateUSD;
	private List<CostDetailsCurrency> costDetailsCurrencies;

	public CostDetails() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cost_details_id", unique = true, nullable = false)
	public Long getCostDetailsId() {
		return costDetailsId;
	}

	public void setCostDetailsId(Long costDetailsId) {
		this.costDetailsId = costDetailsId;
	}

	@Column(name = "extra_cost_description")
	public String getExtraCostDescription() {
		return extraCostDescription;
	}

	public void setExtraCostDescription(String extraCostDescription) {
		this.extraCostDescription = extraCostDescription;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "product_month")
	public String getProductMonth() {
		return productMonth;
	}

	public void setProductMonth(String productMonth) {
		this.productMonth = productMonth;
	}

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@JsonBackReference
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "costDetails")
	@JsonBackReference
	public List<CostDetailsCurrency> getCostDetailsCurrencies() {
		return costDetailsCurrencies;
	}

	public void setCostDetailsCurrencies(List<CostDetailsCurrency> costDetailsCurrencies) {
		this.costDetailsCurrencies = costDetailsCurrencies;
	}

	@Column(name = "rate_pound")
	public String getRatePound() {
		return ratePound;
	}

	public void setRatePound(String ratePound) {
		this.ratePound = ratePound;
	}

	@Column(name = "rate_usd")
	public String getRateUSD() {
		return rateUSD;
	}

	public void setRateUSD(String rateUSD) {
		this.rateUSD = rateUSD;
	}

}
