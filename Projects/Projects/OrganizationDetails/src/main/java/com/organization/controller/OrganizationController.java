package com.organization.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;
import com.organization.service.OrganizationService;
import com.organization.shared.dto.OrganizationDetailsDto;



@RestController
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@PostMapping()
	public OrganizationDetailsResponseModel saveOrganizationDetails(@RequestBody OrganizationDetailsRequestModel organization)
	{
		OrganizationDetailsResponseModel res=new OrganizationDetailsResponseModel();
		
		OrganizationDetailsDto orgdto=new OrganizationDetailsDto();
		
		BeanUtils.copyProperties(organization, orgdto);
		OrganizationDetailsDto createdUser = organizationService.createOrganization(orgdto);
		BeanUtils.copyProperties(createdUser, res);
		
		return res;
	}
	
	@GetMapping("/{id}")
	public OrganizationDetailsResponseModel getByOrganizationId(@PathVariable("id") String organizationKey)
	{
		OrganizationDetailsResponseModel orgResModel=new OrganizationDetailsResponseModel();
		OrganizationDetailsDto orgDetailsDto=organizationService.getByOrganizationKey(organizationKey);
		BeanUtils.copyProperties(orgDetailsDto,orgResModel);
		return orgResModel;
	}
	
	@GetMapping()
	public List<OrganizationDetailsResponseModel> getAllOrganization(@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam(value="limit",defaultValue="25")int limit)
	{
		List<OrganizationDetailsResponseModel> orgDetailsResMod=new ArrayList<>();
		List<OrganizationDetailsDto> orgDetailsDto=organizationService.getAllOrganization(page,limit);

		for(OrganizationDetailsDto  orgDto : orgDetailsDto)
		{
			OrganizationDetailsResponseModel orgDetailsRes=new OrganizationDetailsResponseModel();
			BeanUtils.copyProperties(orgDto, orgDetailsRes);
			orgDetailsResMod.add(orgDetailsRes);
		}
		
		return orgDetailsResMod;
	}
	
	@PutMapping("{id}")
	public  OrganizationDetailsResponseModel  updateOrganizationById(@PathVariable("id")String organizationKey,
			@RequestBody OrganizationDetailsRequestModel organization)
	{
		OrganizationDetailsResponseModel orgResModel=new OrganizationDetailsResponseModel();
		OrganizationDetailsDto orgDetails=new OrganizationDetailsDto();
		BeanUtils.copyProperties(organization,orgDetails);
		OrganizationDetailsDto update=organizationService.
				updateByOrganizaionKey(organizationKey, orgDetails);
		BeanUtils.copyProperties(update,orgResModel);
				return orgResModel;
	}
	
	@DeleteMapping("/{id}")
	public  OperationStatusModel deleteByOrganizationKey(@PathVariable("id") String organizationKey)
	{
		OperationStatusModel opStatusModel=new OperationStatusModel();
		opStatusModel.setOperationName(RequestOperationName.DELETE.name());
		organizationService.deleteByOrganizationKey(organizationKey);
		opStatusModel.setOperationResult(RequestOperationStatus.Success.name());
		return  opStatusModel;
	}
}
