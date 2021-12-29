package com.proretention.organization.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="Details about the Organization Details Response")
public class OrganizationDetailsResponseModel {
	@ApiModelProperty(notes="The unique Id for organization")
	private long organizationId;
	@ApiModelProperty(notes="The unique key for organization")
	private String organizationKey;
	@ApiModelProperty(notes="The unique Id for user")
	private long userId;
	@ApiModelProperty(notes="The unique key for user")
	private String userKey;
	@ApiModelProperty(notes="Address of the organization")
	private String address;
	@ApiModelProperty(notes="Country Name the organization")
	private String country;
	@ApiModelProperty(notes="CityName of  the organization")
	private String city;
	@ApiModelProperty(notes="StateName of the organization")
	private String state;
	@ApiModelProperty(notes="ZipCode of  the organization")
	private long zipCode;
	@ApiModelProperty(notes="LocationUrl of the organization")
	private String locationUrl;
	@ApiModelProperty(notes="WebsiteUrl for  organization")
	private String websiteUrl;
	@ApiModelProperty(notes="Industry Details")
	private String insdustry;
	@ApiModelProperty(notes="BusinessType for organization")
	private String bussinessType;
	@ApiModelProperty(notes="TaxId for organization")
	private long taxId;
	@ApiModelProperty(notes="The unique Id of the company")
	private long companyId;
	@ApiModelProperty(notes=" about  organization details")
	private String aboutUs;
	


}
