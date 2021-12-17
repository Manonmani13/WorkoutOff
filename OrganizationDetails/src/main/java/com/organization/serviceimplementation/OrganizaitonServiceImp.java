package com.organization.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		BeanUtils.copyProperties(orgdto,orgdetails);
		String organikey="user"+orgdetails.getState();
		orgdetails.setOrganizationKey(organikey);
		OrganizationDetails orgStored=organizationRepository.save(orgdetails);
		OrganizationDetailsDto orgDto=new OrganizationDetailsDto();
		BeanUtils.copyProperties(orgStored, orgDto);
	
		return orgDto;
	
}

	public OrganizationDetailsDto getByOrganizationKey(String organizationKey) {
		OrganizationDetailsDto orgDetailsDto=new OrganizationDetailsDto();
		OrganizationDetails organizationDetails=
				organizationRepository.findByOrganizationKey(organizationKey);
		BeanUtils.copyProperties(organizationDetails,orgDetailsDto );
		return orgDetailsDto;
	}
	

	public  void deleteByOrganizationKey(String organizationKey) {
		OrganizationDetails orgDetails=organizationRepository.findByOrganizationKey(organizationKey);
		organizationRepository.delete(orgDetails);
	}

	@Override
	public OrganizationDetailsDto updateByOrganizaionKey(String organizationKey, OrganizationDetailsDto orgDetails) {
	
		OrganizationDetailsDto orgDetailsDto=new OrganizationDetailsDto();
		OrganizationDetails existingOrganization = organizationRepository.findByOrganizationKey(organizationKey);
		existingOrganization.setUserKey(orgDetails.getUserKey());
		existingOrganization.setAddress(orgDetails.getAddress());
		existingOrganization.setCountry(orgDetails.getCountry());
		existingOrganization.setCity(orgDetails.getCity());
		existingOrganization.setState(orgDetails.getState());
		existingOrganization.setZipCode(orgDetails.getZipCode());
		existingOrganization.setLocationUrl(orgDetails.getLocationUrl());
		existingOrganization.setWebsiteUrl(orgDetails.getWebsiteUrl());
		existingOrganization.setInsdustry(orgDetails.getInsdustry());
		existingOrganization.setBussinessType(orgDetails.getBussinessType());
		existingOrganization.setTaxId(orgDetails.getTaxId());
		existingOrganization.setCompanyId(orgDetails.getCompanyId());
		existingOrganization.setAboutUs(orgDetails.getAboutUs());
		OrganizationDetails updateDetails=organizationRepository.save(existingOrganization);
		BeanUtils.copyProperties( updateDetails,orgDetailsDto);
		return orgDetailsDto;

	}

	@Override
	public List<OrganizationDetailsDto> getAllOrganization(int page, int limit) {
		
	
			List<OrganizationDetailsDto> orgResponse=new ArrayList<>();
			if(page>0)
			{
				page=page-1;
			}
			Pageable pageRequest=PageRequest.of(page, limit);
			
			Page<OrganizationDetails> orgPage=organizationRepository.findAll(pageRequest);
			List<OrganizationDetails> organization=orgPage.getContent();
			for(OrganizationDetails orgDetails:organization)
			{
				OrganizationDetailsDto orgDto=new OrganizationDetailsDto();
				BeanUtils.copyProperties(orgDetails, orgDto);
				orgResponse.add(orgDto);
			}
			
			return orgResponse;
	}

	
}
