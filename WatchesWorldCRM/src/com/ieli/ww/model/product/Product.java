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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ieli.ww.model.product.costs.CostDetails;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productId;
	private String brand;
	private String model;
	private String productReference;
	private String productCase;
	private String bracelet;
	private String dial;
	private String year;
	private String condition;
	private String serial;
	private Boolean hasBox;
	private Boolean hasPapers;
	private String availabilityStatus;
	private String paymentStatus;
	private String currentLocation;
	private String boughtFromCountry;
	private String supplierName;
	private String soldInCountry;
	private String clientName;
	private Integer clientAge;
	private String clientGender;
	private String imagePath;

	private String dateAdded;
	private String dateModified;
	private String dateDeleted;
	private String dateSold;
	private String month;

	private boolean enabled;

	private CostDetails costDetails;

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
	public CostDetails getCostDetails() {
		return costDetails;
	}

	public void setCostDetails(CostDetails costDetails) {
		this.costDetails = costDetails;
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
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	@Column(name = "current_location")
	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	@Column(name = "bought_from_country")
	public String getBoughtFromCountry() {
		return boughtFromCountry;
	}

	public void setBoughtFromCountry(String boughtFromCountry) {
		this.boughtFromCountry = boughtFromCountry;
	}

	@Column(name = "sold_in_country")
	public String getSoldInCountry() {
		return soldInCountry;
	}

	public void setSoldInCountry(String soldInCountry) {
		this.soldInCountry = soldInCountry;
	}

	@Column(name = "supplier_name")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "client_name")
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "client_age")
	public Integer getClientAge() {
		return clientAge;
	}

	public void setClientAge(Integer clientAge) {
		this.clientAge = clientAge;
	}

	@Column(name = "client_gender")
	public String getClientGender() {
		return clientGender;
	}

	public void setClientGender(String clientGender) {
		this.clientGender = clientGender;
	}

	@Column(name = "month")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "image_path")
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
