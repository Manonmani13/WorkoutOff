package com.proretention.module.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.proretention.module.dto.ModuleDto;
import com.proretention.module.entity.ModuleEntity;
import com.proretention.module.exception.ResourceNotFound;
import com.proretention.module.repository.ModuleRepository;
import com.proretention.module.request.ModuleRequest;
import com.proretention.module.service.ModuleService;

@Service
public class ModuleServiceImp implements ModuleService {
	@Autowired
	public ModuleRepository moduleRepository;

	@Override
	public ModuleDto createModule(ModuleDto moduleDto) {
		try
		{
	
		if(moduleDto.getModuleDescription().isEmpty()||moduleDto.getModuleName().isEmpty()||moduleDto.getModuleDescription().isBlank()
				||moduleDto.getModuleName().isBlank())
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
		ModuleEntity module = new ModuleEntity();
		BeanUtils.copyProperties(moduleDto, module);

		ModuleEntity moduleStore = moduleRepository.save(module);
		String moduleKey = "abc" + module.getModuleId();
		module.setModuleKey(moduleKey);
		ModuleEntity moduleStored = moduleRepository.save(module);
		ModuleDto moduleDtos = new ModuleDto();
		BeanUtils.copyProperties(moduleStored, moduleDtos);
		return moduleDtos;
	}

	@Override
	public ModuleDto getByModuleKey(String moduleKey) {
		try
		{
		ModuleDto moduleDto = new ModuleDto();
		ModuleEntity module = moduleRepository.getByModuleKey(moduleKey);
		BeanUtils.copyProperties(module, moduleDto);
		return moduleDto;
		}
		catch(IllegalArgumentException e)
		{
		throw new  ResourceNotFound("given  module key  not exist");	
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("something  went wrong  in service layer");
		}
	}

	@Override
	public List<ModuleDto> getAllModule(int page, int limit) {
		List<ModuleDto> moduleResp = new ArrayList<>();
		if (page > 0) {
			page = page - 1;
		}
		PageRequest pageRequest = PageRequest.of(page, limit);

		Page<ModuleEntity> module = moduleRepository.findAll(pageRequest);
		List<ModuleEntity> moduleRes = module.getContent();
		for (ModuleEntity moduleEn : moduleRes) {
			ModuleDto moduleDto = new ModuleDto();
			BeanUtils.copyProperties(moduleEn, moduleDto);
			moduleResp.add(moduleDto);
		}
		return moduleResp;
	}

@Override
public ModuleDto updateModuleDetails(String moduleKey, ModuleRequest module) {
	try
	{

	if(module.getModuleDescription().isEmpty()||module.getModuleName().isEmpty()||module.getModuleDescription().isBlank()
			||module.getModuleName().isBlank())
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
	ModuleDto moduledto=new ModuleDto();
	ModuleEntity updatingDetails=moduleRepository.getByModuleKey(moduleKey);
	try
	{
		if(updatingDetails==null)
			throw new IllegalArgumentException("there is no data");
	}
	catch(IllegalArgumentException e)
	{
		throw new ResourceNotFound("Given ModuleKey does not exists in db");
		
	}
	catch(Exception e)
	{
		throw new ResourceNotFound("Something went wrong in service layer");
	}
	updatingDetails.setModuleName(module.getModuleName());
	updatingDetails.setModuleDescription(module.getModuleDescription());
	ModuleEntity updated=moduleRepository.save(updatingDetails);
	BeanUtils.copyProperties( updated,moduledto);
	return moduledto;
}

@Override
public void deleteByModuleKey(String moduleKey) {
	ModuleEntity module=moduleRepository.getByModuleKey(moduleKey);
	try
	{
		if(module==null)
			throw new IllegalArgumentException("Module key is null");
	}
	catch(IllegalArgumentException  e) {
		throw new  ResourceNotFound("give Module key is doesnt exist in db");
	}
	catch(Exception e)
	{
		throw new ResourceNotFound("Something  went wrong  in service layer");
	}
	moduleRepository.delete(module);
	
}

}
