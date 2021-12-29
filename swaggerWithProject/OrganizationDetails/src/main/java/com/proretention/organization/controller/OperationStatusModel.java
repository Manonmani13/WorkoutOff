package com.proretention.organization.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@ApiModel(description="Details about the Operation Status")
public class OperationStatusModel {
@ApiModelProperty(notes="Result of the operation")
private String operationResult;
@ApiModelProperty(notes="Name of the operation")
private String operationName;


}
