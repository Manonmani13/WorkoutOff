package com.module.controller;

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

import com.module.dto.ModuleDto;
import com.module.request.ModuleRequest;
import com.module.response.ModuleResponse;
import com.module.service.ModuleService;


@RestController
@RequestMapping("/module")
public class ModuleController 
{
@Autowired
public ModuleService moduleService;
@PostMapping()
public ModuleResponse saveModuleDetails(@RequestBody ModuleRequest module)
{
	ModuleResponse moduleRes=new ModuleResponse();
	ModuleDto moduleDto=new ModuleDto();
	BeanUtils.copyProperties(module, moduleDto);
	ModuleDto moduledto=moduleService.createModule(moduleDto);
	BeanUtils.copyProperties(moduledto,moduleRes);
	return moduleRes;
}
@GetMapping("/{id}")
public ModuleResponse getByModuleKey(@PathVariable ("id") String moduleKey)
{
	ModuleResponse moduleRes=new ModuleResponse();
	
	ModuleDto moduleDto=moduleService.getByModuleKey(moduleKey);
	BeanUtils.copyProperties( moduleDto,moduleRes);
	return moduleRes;
}

@GetMapping()
public List<ModuleResponse> getAllModule(@RequestParam(value="page",defaultValue="1")int page,
		@RequestParam(value="limit",defaultValue="20")int limit)
{
	List<ModuleResponse> moduleResp=new ArrayList<>();
	List<ModuleDto> moduleDto= moduleService.getAllModule(page,limit);
	for(ModuleDto module:moduleDto)
	{
		ModuleResponse moduleRes=new ModuleResponse();
		BeanUtils.copyProperties(module,moduleRes);
		moduleResp.add(moduleRes);
	}
	return moduleResp;
}
@PutMapping("/{id}")
public ModuleResponse updateModule(@PathVariable("id")String moduleKey,@RequestBody ModuleRequest module)
{
	ModuleResponse moduleRes=new ModuleResponse();
	ModuleDto moduleDto=new ModuleDto();
	BeanUtils.copyProperties(module, moduleDto);
	ModuleDto update=moduleService.updateModuleDetails(moduleKey,module);
	BeanUtils.copyProperties( update,moduleRes);
	return moduleRes;
}
@DeleteMapping("/{id}")
public OperationStatusModel deleteModule(@PathVariable("id")String moduleKey)
{
	OperationStatusModel opStaMod=new OperationStatusModel();
	opStaMod.setOperationName(RequestOperationName.DELETE.name());
	moduleService.deleteByModuleKey(moduleKey);
	opStaMod.setOperationresult(RequestOperationStatus.Success.name());
	return  opStaMod;
	
}
}
