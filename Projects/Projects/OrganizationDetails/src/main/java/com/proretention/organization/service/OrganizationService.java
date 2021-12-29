package com.organization.service;

import java.util.List;

import com.organization.entity.OrganizationDetails;
import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;
import com.organization.shared.dto.OrganizationDetailsDto;

public interface OrganizationService {

	
	public OrganizationDetailsDto createOrganization(OrganizationDetailsDto orgdto);

	public OrganizationDetailsDto getByOrganizationKey(String organizationKey);

	public void deleteByOrganizationKey(String organizationKey);

	public OrganizationDetailsDto updateByOrganizaionKey(String organizationKey, OrganizationDetailsDto orgDetails);

	public List<OrganizationDetailsDto> getAllOrganization(int page, int limit);

			
}
