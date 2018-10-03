package com.ieli.ww.model.product;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ieli.ww.model.product.costs.CostDetails;
import com.ieli.ww.model.product.details.CountryDetails;
import com.ieli.ww.model.product.details.ProductDetails;
import com.ieli.ww.model.product.parties.Client;
import com.ieli.ww.model.product.parties.Supplier;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productId;
	private String brand;
	private String model;
	private String dateAdded;
	private String dateModified;
	private String dateDeleted;
	private String dateSold;
	private String productReference;
	private String year;
	private String serial;
	private boolean enabled;

	// Relationships
	private ProductDetails productDetails;
	private Client client;
	private Supplier supplier;
	private CostDetails costDetails;
	private CountryDetails countryDetails;

	public Product() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "brand")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "date_added")
	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Column(name = "date_modified")
	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	@Column(name = "date_deleted")
	public String getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(String dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	@Column(name = "date_sold")
	public String getDateSold() {
		return dateSold;
	}

	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	@Column(name = "product_reference")
	public String getProductReference() {
		return productReference;
	}

	public void setProductReference(String productReference) {
		this.productReference = productReference;
	}

	@Column(name = "year")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "serial")
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
	@JsonManagedReference
	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	@Transient
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Transient
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
	@JsonManagedReference
	public CostDetails getCostDetails() {
		return costDetails;
	}

	public void setCostDetails(CostDetails costDetails) {
		this.costDetails = costDetails;
	}

	@Transient
	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}

}
