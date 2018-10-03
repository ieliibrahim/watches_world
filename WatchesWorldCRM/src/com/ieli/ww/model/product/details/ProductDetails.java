package com.ieli.ww.model.product.details;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ieli.ww.model.product.Product;

@Entity
@Table(name = "product_details")
public class ProductDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productDetailsId;
	private String productCase;
	private String bracelet;
	private String dial;
	private String condition;
	private Boolean hasBox;
	private Boolean hasPapers;
	private String paymentStatus;
	private Boolean availabilityStatus;
	private boolean enabled;
	private Product product;

	public ProductDetails() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_details_id", unique = true, nullable = false)
	public Long getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(Long productDetailsId) {
		this.productDetailsId = productDetailsId;
	}

	@Column(name = "product_case")
	public String getProductCase() {
		return productCase;
	}

	public void setProductCase(String productCase) {
		this.productCase = productCase;
	}

	@Column(name = "bracelet")
	public String getBracelet() {
		return bracelet;
	}

	public void setBracelet(String bracelet) {
		this.bracelet = bracelet;
	}

	@Column(name = "dial")
	public String getDial() {
		return dial;
	}

	public void setDial(String dial) {
		this.dial = dial;
	}

	@Column(name = "condition")
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Column(name = "has_box")
	public Boolean getHasBox() {
		return hasBox;
	}

	public void setHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
	}

	@Column(name = "has_papers")
	public Boolean getHasPapers() {
		return hasPapers;
	}

	public void setHasPapers(Boolean hasPapers) {
		this.hasPapers = hasPapers;
	}

	@Column(name = "payment_status")
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Column(name = "availability_status")
	public Boolean getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(Boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

}
