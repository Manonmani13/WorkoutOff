package com.organization.shared.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
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

}
