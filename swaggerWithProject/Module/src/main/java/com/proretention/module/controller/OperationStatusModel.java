package com.proretention.module.controller;

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
@ApiModel(description="Details about the Operation Status")
public class OperationStatusModel {
	@ApiModelProperty(notes="Result of the operation")
private String operationName;
	@ApiModelProperty(notes="Name of the operation")
private String operationresult;
}
