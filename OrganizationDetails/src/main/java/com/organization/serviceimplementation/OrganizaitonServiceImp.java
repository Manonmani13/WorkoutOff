package com.organization.serviceimplementation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entity.OrganizationDetails;
import com.organization.repository.OrganizationRepository;
import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;
import com.organization.service.OrganizationService;
import com.organization.shared.dto.OrganizationDetailsDto;

@Service
public class OrganizaitonServiceImp implements OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;
	
	public OrganizationDetailsDto createOrganization(OrganizationDetailsDto orgdto) {
		
		OrganizationDetails orgdetails = new OrganizationDetails();
		BeanUtils.copyProperties(orgdto, orgdetails);
		OrganizationDetails storedUserDetails = organizationRepository.save(orgdetails);
		
		OrganizationDetailsDto retVal = new OrganizationDetailsDto();
		BeanUtils.copyProperties(storedUserDetails, retVal);
		
		return retVal;
	
}

	public OrganizationDetails getByOrganizationId(long organizationId) {
		return organizationRepository.getByOrganizationId(organizationId);
	}
	
	public List<OrganizationDetails> getAllOrganization() {

		return organizationRepository.findAll();
	}

public OrganizationDetails updateOrganizaionById(OrganizationDetails organization) {
		OrganizationDetails existingOrganization = organizationRepository.getByOrganizationId(organization.getOrganizationId());
		existingOrganization.setOrganizationKey(organization.getOrganizationKey());
		existingOrganization.setUserKey(organization.getUserKey());
		existingOrganization.setAddress(organization.getAddress());
		existingOrganization.setCountry(organization.getCountry());
		existingOrganization.setCity(organization.getCity());
		existingOrganization.setState(organization.getState());
		existingOrganization.setZipCode(organization.getZipCode());
		existingOrganization.setLocationUrl(organization.getLocationUrl());
		existingOrganization.setWebsiteUrl(organization.getWebsiteUrl());
		existingOrganization.setInsdustry(organization.getInsdustry());
		existingOrganization.setBussinessType(organization.getBussinessType());
		existingOrganization.setTaxId(organization.getTaxId());
		existingOrganization.setCompanyId(organization.getCompanyId());
		existingOrganization.setAboutUs(organization.getAboutUs());
		return organizationRepository.save(existingOrganization);
	}

	public String deleteOrganizationById(long organizationId) {
		organizationRepository.deleteById(organizationId);
		return organizationId + "this id is deleted Successfully";
	}

}
