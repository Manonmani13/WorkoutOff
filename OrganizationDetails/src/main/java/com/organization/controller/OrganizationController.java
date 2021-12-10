package com.organization.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.organization.entity.OrganizationDetails;
import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;
import com.organization.service.OrganizationService;
import com.organization.serviceimplementation.OrganizaitonServiceImp;
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
	public OrganizationDetails getByOrganizationId(@PathVariable("id") long organizationId)
	{
		return organizationService.getByOrganizationId(organizationId);
	}
	
	@GetMapping()
	public List<OrganizationDetails> getAllOrganization()
	{
		return organizationService.getAllOrganization();
	}
	
	@PutMapping()
	public  OrganizationDetails  updateOrganizationById(@RequestBody OrganizationDetails organization)
	{
		return organizationService.updateOrganizaionById(organization);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrganizationById(@PathVariable("id") long organizationId)
	{
		return organizationService.deleteOrganizationById(organizationId);
	}
}
