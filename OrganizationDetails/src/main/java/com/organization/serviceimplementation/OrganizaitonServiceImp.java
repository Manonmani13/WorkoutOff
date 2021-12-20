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
import com.organization.exception.ResourceNotFound;
import com.organization.repository.OrganizationRepository;
import com.organization.service.OrganizationService;
import com.organization.shared.dto.OrganizationDetailsDto;

@Service
public class OrganizaitonServiceImp implements OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;
	
	public OrganizationDetailsDto createOrganization(OrganizationDetailsDto orgdto) {
		try
		{
	
		if(orgdto.getAboutUs().isEmpty()||orgdto.getAddress().isEmpty()||orgdto.getBussinessType().isEmpty()
				||orgdto.getCity().isEmpty()||orgdto.getCompanyId()==0||orgdto.getCountry().isEmpty()
				||orgdto.getInsdustry().isEmpty()||orgdto.getLocationUrl().isEmpty()
				||orgdto.getState().isEmpty()||orgdto.getTaxId()==0||orgdto.getUserKey().isEmpty()
				||orgdto.getWebsiteUrl().isEmpty()||orgdto.getZipCode()==0)
			throw new  ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(ResourceNotFound rs)
		{
			throw new ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("some thing wrong in service");
		}
		OrganizationDetails orgdetails = new OrganizationDetails();
		BeanUtils.copyProperties(orgdto,orgdetails);
		String organikey="user"+orgdetails.getState();
		orgdetails.setOrganizationKey(organikey);
		
		OrganizationDetails orgStored=organizationRepository.save(orgdetails);
		long id=orgdetails.getOrganizationId();
		orgdetails.setUserId(id);
		OrganizationDetails orgStore=organizationRepository.save(orgdetails);
		OrganizationDetailsDto orgDto=new OrganizationDetailsDto();
		BeanUtils.copyProperties(orgStore, orgDto);
	
		return orgDto;
		

}

	public OrganizationDetailsDto getByOrganizationKey(String organizationKey) {
		try
		{
		OrganizationDetailsDto orgDetailsDto=new OrganizationDetailsDto();
		OrganizationDetails organizationDetails=
				organizationRepository.findByOrganizationKey(organizationKey);
		BeanUtils.copyProperties(organizationDetails,orgDetailsDto );
		return orgDetailsDto;
		}
		catch(IllegalArgumentException e)
		{
		throw new  ResourceNotFound("given  organizationkey  not exist");	
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("something  went wrong  in service layer");
		}
	}
	

	public  void deleteByOrganizationKey(String organizationKey) {
		OrganizationDetails orgDetails=organizationRepository.findByOrganizationKey(organizationKey);
		try
		{
			if(orgDetails==null)
				throw new IllegalArgumentException("Organization key is null");
		}
		catch(IllegalArgumentException  e) {
			throw new  ResourceNotFound("give organization key is doesnt exist in db");
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("Something  went wrong  in service layer");
		}
		organizationRepository.delete(orgDetails);
	}

	@Override
	public OrganizationDetailsDto updateByOrganizaionKey(String organizationKey, OrganizationDetailsDto orgDetails) {
		try
		{
	
		if(orgDetails.getAboutUs().isEmpty()||orgDetails.getAddress().isEmpty()||orgDetails.getBussinessType().isEmpty()
				||orgDetails.getCity().isEmpty()||orgDetails.getCompanyId()==0||orgDetails.getCountry().isEmpty()
				||orgDetails.getInsdustry().isEmpty()||orgDetails.getLocationUrl().isEmpty()||
				orgDetails.getState().isEmpty()||
				         orgDetails.getTaxId()==0||orgDetails.getUserKey().isEmpty()
				||orgDetails.getWebsiteUrl().isEmpty()||orgDetails.getZipCode()==0)
			throw new  ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(ResourceNotFound rs)
		{
			throw new ResourceNotFound("please give proper input because there is some filed null");
		}

		OrganizationDetailsDto orgDetailsDto=new OrganizationDetailsDto();
		OrganizationDetails existingOrganization = organizationRepository.findByOrganizationKey(organizationKey);
		try
		{
			if(existingOrganization==null)
				throw new IllegalArgumentException("there is no data");
		}
		catch(IllegalArgumentException e)
		{
			throw new ResourceNotFound("Given organizationKey does not exists in db");
			
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("Something went wrong in service layer");
		}
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
