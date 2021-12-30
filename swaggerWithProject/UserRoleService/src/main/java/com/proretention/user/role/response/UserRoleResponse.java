package com.proretention.user.role.response;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="Details about UserRoleResponse")
public class UserRoleResponse {
	@ApiModelProperty(notes="Id of the role")
	private long roleId;
	@ApiModelProperty(notes="Id of the user")
	private long userId;
	@ApiModelProperty(notes="Name of the user role")
	private String userRole;
	
	
}
