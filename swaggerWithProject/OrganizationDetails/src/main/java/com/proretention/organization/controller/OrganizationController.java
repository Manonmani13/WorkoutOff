package com.proretention.organization.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.proretention.organization.request.model.OrganizationDetailsRequestModel;
import com.proretention.organization.response.OrganizationDetailsResponseModel;
import com.proretention.organization.service.OrganizationService;
import com.proretention.organization.shared.dto.OrganizationDetailsDto;

import io.swagger.annotations.ApiOperation;




@RestController
@RequestMapping("/organization")
public class OrganizationController {
	 Logger logger = LogManager.getLogger(OrganizationController.class);

	@Autowired
	private OrganizationService organizationService;

	@PostMapping()
	@ApiOperation(value="this method is used to save organization details",
	notes="give details about your organization to save",
	response=OrganizationDetailsResponseModel.class)
	
	public OrganizationDetailsResponseModel saveOrganizationDetails(@RequestBody OrganizationDetailsRequestModel organization)
	{
	
			logger.info("Organization saveDetailsMethod started");
			OrganizationDetailsResponseModel res=new OrganizationDetailsResponseModel();
			
			OrganizationDetailsDto orgdto=new OrganizationDetailsDto();
			
			BeanUtils.copyProperties(organization, orgdto);
			OrganizationDetailsDto createdUser = organizationService.createOrganization(orgdto);
			BeanUtils.copyProperties(createdUser, res);
			logger.info("Organization saveDetailsMethod completed");
			return res;
	}
	@GetMapping("/{id}")
	@ApiOperation(value="this method is used to find organization details by Key",
	notes="find details about your organization by organizationKey",
	response=OrganizationDetailsResponseModel.class)
	public OrganizationDetailsResponseModel getByOrganizationId(@PathVariable("id") String organizationKey)
	{
		logger.info("Organization getByOrganizationIdMethod started");
		OrganizationDetailsResponseModel orgResModel=new OrganizationDetailsResponseModel();
		OrganizationDetailsDto orgDetailsDto=organizationService.getByOrganizationKey(organizationKey);
		BeanUtils.copyProperties(orgDetailsDto,orgResModel);
		logger.info("Organization getByOrganizationIdMethod completed");
		return orgResModel;
	}
	
	@GetMapping()
	@ApiOperation(value="this method is used to find all organization details",
	notes="find details about  all organization ",
	response=OrganizationDetailsResponseModel.class)
	public List<OrganizationDetailsResponseModel> getAllOrganization(@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam(value="limit",defaultValue="25")int limit)
	{
		logger.info("Organization getAllOrganizationMethod started");
		List<OrganizationDetailsResponseModel> orgDetailsResMod=new ArrayList<>();
		List<OrganizationDetailsDto> orgDetailsDto=organizationService.getAllOrganization(page,limit);

		for(OrganizationDetailsDto  orgDto : orgDetailsDto)
		{
			OrganizationDetailsResponseModel orgDetailsRes=new OrganizationDetailsResponseModel();
			BeanUtils.copyProperties(orgDto, orgDetailsRes);
			orgDetailsResMod.add(orgDetailsRes);
		}
		logger.info("Organization getByOrganizationIdMethod completed");
		return orgDetailsResMod;
	}
	
	@PutMapping("{id}")
	@ApiOperation(value="this method is used to update organization details",
	notes="give organizationKey  to update your organization details ",
	response=OrganizationDetailsResponseModel.class)
	public  OrganizationDetailsResponseModel  updateOrganizationById(@PathVariable("id")String organizationKey,
			@RequestBody OrganizationDetailsRequestModel organization)
	{
		logger.info("Organization updatedOrganizationByIdMethod started");
		OrganizationDetailsResponseModel orgResModel=new OrganizationDetailsResponseModel();
		OrganizationDetailsDto orgDetails=new OrganizationDetailsDto();
		BeanUtils.copyProperties(organization,orgDetails);
		OrganizationDetailsDto update=organizationService.
				updateByOrganizaionKey(organizationKey, orgDetails);
		BeanUtils.copyProperties(update,orgResModel);
		logger.info("Organization updatedByOrganizationIdMethod completed");
				return orgResModel;
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="this method is used to delete organization details",
	notes="give you organizationKey  to delete your details",
	response=OrganizationDetailsResponseModel.class)
	public  OperationStatusModel deleteByOrganizationKey(@PathVariable("id") String organizationKey)
	{
		logger.info("Organization deleteByOrganizationKey Method started");
		OperationStatusModel opStatusModel=new OperationStatusModel();
		opStatusModel.setOperationName(RequestOperationName.DELETE.name());
		organizationService.deleteByOrganizationKey(organizationKey);
		opStatusModel.setOperationResult(RequestOperationStatus.Success.name());
		logger.info("Organization deleteByOrganizationKey Method completed");
		return  opStatusModel;
	}
}
