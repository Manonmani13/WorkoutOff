package com.proretention.module.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="Details about the Module Response")
public class ModuleResponse {
	@ApiModelProperty(notes="Id of the module")
	private long moduleId;
	@ApiModelProperty(notes="Key of the module")
	private String moduleKey;
	@ApiModelProperty(notes="Name of the  module")
	private String moduleName;
	@ApiModelProperty(notes="Description of the module")
	private String moduleDescription;
}
