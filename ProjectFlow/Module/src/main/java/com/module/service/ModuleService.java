package com.module.service;

import java.util.List;

import com.module.dto.ModuleDto;
import com.module.request.ModuleRequest;

public interface ModuleService {

	ModuleDto createModule(ModuleDto moduleDto);

	ModuleDto getByModuleKey(String moduleKey);

	List<ModuleDto> getAllModule(int page, int limit);

	ModuleDto updateModuleDetails(String moduleKey, ModuleRequest module);

	void deleteByModuleKey(String moduleKey);

}
