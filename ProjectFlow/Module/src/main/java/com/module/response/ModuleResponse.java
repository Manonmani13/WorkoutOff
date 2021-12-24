package com.module.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleResponse {
	private long moduleId;
	private String moduleKey;
	private String moduleName;
	private String moduleDescription;
}
