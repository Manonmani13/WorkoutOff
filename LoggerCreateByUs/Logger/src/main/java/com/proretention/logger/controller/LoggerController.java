package com.proretention.logger.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proretention.logger.request.LoggerRequest;
import com.proretention.logger.service.LoggerService;

@RestController
@RequestMapping("/logger")
public class LoggerController {
	@Autowired
	LoggerService loggerService;
	@PostMapping("/")
	public  void saveLoggertInfo(@RequestBody LoggerRequest logger)
	{
		loggerService.saveLog(logger.getIpAddress(), logger.getApiUrl(), logger.getResponse());
	}
}
