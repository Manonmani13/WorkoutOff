package com.organization.request.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDetailsRequestModel {


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

	
}
