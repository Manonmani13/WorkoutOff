package com.proretention.organization.service;

import java.util.List;

import com.proretention.organization.entity.OrganizationDetails;
import com.proretention.organization.request.model.OrganizationDetailsRequestModel;
import com.proretention.organization.response.OrganizationDetailsResponseModel;
import com.proretention.organization.shared.dto.OrganizationDetailsDto;

public interface OrganizationService {

	
	public OrganizationDetailsDto createOrganization(OrganizationDetailsDto orgdto);

	public OrganizationDetailsDto getByOrganizationKey(String organizationKey);

	public void deleteByOrganizationKey(String organizationKey);

	public OrganizationDetailsDto updateByOrganizaionKey(String organizationKey, OrganizationDetailsDto orgDetails);

	public List<OrganizationDetailsDto> getAllOrganization(int page, int limit);

			
}
