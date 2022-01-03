package com.proretention.logger.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoggerRequest {
	private String ipAddress;
	private String apiUrl;
	private String response;
}
