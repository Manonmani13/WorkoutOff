package com.organization.shared.dto;

import java.io.Serializable;

public class OrganizationDetailsDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long organizationId;
	private String organizationKey;
	private long userId;
	private String userKey;
	private String address;
	private String country;
	private String city;
	private String state;
	private long zipCode;
	private String locationUrl;
	private String websiteUrl;
	private String insdustry;
	private String bussinessType;
	private long taxId;
	private long companyId;
	private String aboutUs;
	
	public long getOrganizationId() {
		return organizationId;
	}
	
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	
	public String getOrganizationKey() {
		return organizationKey;
	}
	
	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserKey() {
		return userKey;
	}
	
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public long getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getLocationUrl() {
		return locationUrl;
	}
	
	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}
	
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	public String getInsdustry() {
		return insdustry;
	}
	
	public void setInsdustry(String insdustry) {
		this.insdustry = insdustry;
	}
	
	public String getBussinessType() {
		return bussinessType;
	}
	
	public void setBussinessType(String bussinessType) {
		this.bussinessType = bussinessType;
	}
	
	public long getTaxId() {
		return taxId;
	}
	
	public void setTaxId(long taxId) {
		this.taxId = taxId;
	}
	
	public long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	public String getAboutUs() {
		return aboutUs;
	}
	
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public OrganizationDetailsDto(long organizationId, String organizationKey, long userId, String userKey,
			String address, String country, String city, String state, long zipCode, String locationUrl,
			String websiteUrl, String insdustry, String bussinessType, long taxId, long companyId, String aboutUs) {
		super();
		this.organizationId = organizationId;
		this.organizationKey = organizationKey;
		this.userId = userId;
		this.userKey = userKey;
		this.address = address;
		this.country = country;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.locationUrl = locationUrl;
		this.websiteUrl = websiteUrl;
		this.insdustry = insdustry;
		this.bussinessType = bussinessType;
		this.taxId = taxId;
		this.companyId = companyId;
		this.aboutUs = aboutUs;
	}
	
	public OrganizationDetailsDto() {
		super();
	}

	

}
