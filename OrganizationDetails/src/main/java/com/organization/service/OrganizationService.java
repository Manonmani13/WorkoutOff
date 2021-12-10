package com.organization.service;

import java.util.List;

import com.organization.entity.OrganizationDetails;
import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;
import com.organization.shared.dto.OrganizationDetailsDto;

public interface OrganizationService {
	public OrganizationDetails getByOrganizationId(long organizationId);
	public List<OrganizationDetails> getAllOrganization();
	public OrganizationDetails updateOrganizaionById(OrganizationDetails organization);
	public String deleteOrganizationById(long organizationId);



	public OrganizationDetailsDto createOrganization(OrganizationDetailsDto orgdto);



}
