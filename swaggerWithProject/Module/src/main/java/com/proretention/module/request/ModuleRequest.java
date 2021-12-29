package com.proretention.module.request;

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
@ApiModel(description="Details about the Model Request")
public class ModuleRequest {
	@ApiModelProperty(notes="Name of the module")
private String moduleName;
	@ApiModelProperty(notes="Description of the module")
private String moduleDescription;
}
