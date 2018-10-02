package com.ieli.ww.model.product.details;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country_details")
public class CountryDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long countryDetailsId;
	private String boughtFromCountry;
	private String soldInCountry;
	private boolean enabled;
	private Long productId;

	public CountryDetails() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "country_details_id", unique = true, nullable = false)
	public Long getCountryDetailsId() {
		return countryDetailsId;
	}

	public void setCountryDetailsId(Long countryDetailsId) {
		this.countryDetailsId = countryDetailsId;
	}

	@Column(name = "bought_from_country")
	public String getBoughtFromCountry() {
		return boughtFromCountry;
	}

	public void setBoughtFromCountry(String boughtFromCountry) {
		this.boughtFromCountry = boughtFromCountry;
	}

	@Column(name = "bought_from_city")
	public String getSoldInCountry() {
		return soldInCountry;
	}

	public void setSoldInCountry(String soldInCountry) {
		this.soldInCountry = soldInCountry;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "product_id", nullable = false)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
