package com.proretention.module.controller;

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

import com.proretention.module.dto.ModuleDto;
import com.proretention.module.request.ModuleRequest;
import com.proretention.module.response.ModuleResponse;
import com.proretention.module.service.ModuleService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/module")
public class ModuleController 
{

    Logger logger = LogManager.getLogger(ModuleController.class);
@Autowired
public ModuleService moduleService;
@PostMapping()
@ApiOperation(value="this method is used to save module details",
notes="give details about your module to save",
response=ModuleResponse.class)
public ModuleResponse saveModuleDetails(@RequestBody ModuleRequest module)
{
	logger.info("Module saveMethod started");
	ModuleResponse moduleRes=new ModuleResponse();
	ModuleDto moduleDto=new ModuleDto();
	BeanUtils.copyProperties(module, moduleDto);
	ModuleDto moduledto=moduleService.createModule(moduleDto);
	BeanUtils.copyProperties(moduledto,moduleRes);
	logger.info("Module saveMethod completed");
	return moduleRes;
}
@GetMapping("/{id}")

@ApiOperation(value="this method is used to get module details",
notes="find details about  module by key",
response=ModuleResponse.class)
public ModuleResponse getByModuleKey(@PathVariable ("id") String moduleKey)
{
	logger.info("Module getByModuleKeyMethod started");
	ModuleResponse moduleRes=new ModuleResponse();
	
	ModuleDto moduleDto=moduleService.getByModuleKey(moduleKey);
	BeanUtils.copyProperties( moduleDto,moduleRes);
	logger.info("Module getByModuleKeyMethod completed");
	return moduleRes;
}

@GetMapping()

@ApiOperation(value="this method is used to getall module details",
notes="find all details about all module",
response=ModuleResponse.class)
public List<ModuleResponse> getAllModule(@RequestParam(value="page",defaultValue="1")int page,
		@RequestParam(value="limit",defaultValue="20")int limit)
{
	logger.info("Module GetAllModuleMethod started");
	List<ModuleResponse> moduleResp=new ArrayList<>();
	List<ModuleDto> moduleDto= moduleService.getAllModule(page,limit);
	for(ModuleDto module:moduleDto)
	{
		ModuleResponse moduleRes=new ModuleResponse();
		BeanUtils.copyProperties(module,moduleRes);
		moduleResp.add(moduleRes);
	}
	logger.info("Module GetAllModuleMethod completed");
	return moduleResp;
}
@PutMapping("/{id}")

@ApiOperation(value="this method is used to update module details",
notes="update details by modulekey",
response=ModuleResponse.class)
public ModuleResponse updateModule(@PathVariable("id")String moduleKey,@RequestBody ModuleRequest module)
{
	logger.info("Module updateModuleMethod started");
	ModuleResponse moduleRes=new ModuleResponse();
	ModuleDto moduleDto=new ModuleDto();
	BeanUtils.copyProperties(module, moduleDto);
	ModuleDto update=moduleService.updateModuleDetails(moduleKey,module);
	BeanUtils.copyProperties( update,moduleRes);
	logger.info("Module updateModuleMethod completed");
	return moduleRes;
}
@DeleteMapping("/{id}")
@ApiOperation(value="this method is used to delete module details",
notes="delete module details by Key",
response=ModuleResponse.class)
public OperationStatusModel deleteModule(@PathVariable("id")String moduleKey)
{
	logger.info("Module deleteModuleMethod started");
	OperationStatusModel opStaMod=new OperationStatusModel();
	opStaMod.setOperationName(RequestOperationName.DELETE.name());
	moduleService.deleteByModuleKey(moduleKey);
	opStaMod.setOperationresult(RequestOperationStatus.Success.name());
	logger.info("Module deleteModuleMethod completed");
	return  opStaMod;
	
}
}
