package com.ieli.ww.model.product.costs;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ieli.ww.model.product.Product;

@Entity
@Table(name = "cost_details")
public class CostDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long costDetailsId;
	private String month;
	private String extraCostDescription;
	private boolean enabled;
	private Long productId;
	private Product product;
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

	@Column(name = "month")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "product_id", nullable = false)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonBackReference
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Transient
	public List<CostDetailsCurrency> getCostDetailsCurrencies() {
		return costDetailsCurrencies;
	}

	public void setCostDetailsCurrencies(List<CostDetailsCurrency> costDetailsCurrencies) {
		this.costDetailsCurrencies = costDetailsCurrencies;
	}

}
