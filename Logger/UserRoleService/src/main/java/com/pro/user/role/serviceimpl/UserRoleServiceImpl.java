package com.pro.user.role.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pro.user.role.entity.UserRoleEntity;
import com.pro.user.role.exception.ResourceNotFound;
import com.pro.user.role.repository.UserRoleRepository;
import com.pro.user.role.response.UserRoleResponse;
import com.pro.user.role.sensitiveDto.UserRoleDto;
import com.pro.user.role.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	public UserRoleRepository userRoleRepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public UserRoleResponse createRole(UserRoleDto userRoleDto) {
		try
		{
	
		if(userRoleDto.getId()==0||userRoleDto.getUserRole().isBlank()||userRoleDto.getUserRole().isEmpty())
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
		UserRoleEntity userRoleEntity = new UserRoleEntity();
		BeanUtils.copyProperties(userRoleDto, userRoleEntity);
		UserRoleEntity savedUserRole = userRoleRepository.save(userRoleEntity);
		
		UserRoleResponse userRoleResponse = new UserRoleResponse();
		BeanUtils.copyProperties(savedUserRole, userRoleResponse);
		return userRoleResponse;
	}

	@Override
	public UserRoleDto getRoleById(int id) {
		try
		{
		UserRoleDto dto = new UserRoleDto();
		UserRoleEntity entity = userRoleRepository.getById(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
		}
		catch(IllegalArgumentException e)
		{
		throw new  ResourceNotFound("given  user Id  not exist");	
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("something  went wrong  in service layer");
		}
	}

	@Override
	public UserRoleDto updateRole(int id, UserRoleDto dto) {
		try
		{
	
		if(dto.getId()==0||dto.getUserRole().isBlank()||dto.getUserRole().isEmpty())
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
		UserRoleEntity entity = userRoleRepository.getById(id);
		try
		{
			if(entity==null)
				throw new IllegalArgumentException("there is no data");
		}
		catch(IllegalArgumentException e)
		{
			throw new ResourceNotFound("Given UserId does not exists in db");
			
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("Something went wrong in service layer");
		}
		UserRoleEntity userRoleEntity = userRoleRepository.save(entity);
		UserRoleDto esensitiveDto = new UserRoleDto();
		BeanUtils.copyProperties(userRoleEntity, esensitiveDto);
		return esensitiveDto;
	}

	@Override
	public void deleteRole(int id) {
	    UserRoleEntity entity=userRoleRepository.getById(id);
	    try
		{
			if(entity==null)
				throw new IllegalArgumentException("UserId is null");
		}
		catch(IllegalArgumentException  e) {
			throw new  ResourceNotFound("give User Id is doesnt exist in db");
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("Something  went wrong  in service layer");
		}
	    userRoleRepository .delete(entity);
		
	}
}
