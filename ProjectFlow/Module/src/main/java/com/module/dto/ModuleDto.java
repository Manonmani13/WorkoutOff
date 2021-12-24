package com.module.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
	private long moduleId;
	private String moduleKey;
	private String moduleName;
	private String moduleDescription;
}
