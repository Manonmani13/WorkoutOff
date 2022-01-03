package com.proretention.logger.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proretention.logger.entity.LoggerEntity;
import com.proretention.logger.repository.LoggerRepository;

@Service
public class LoggerService {
	@Autowired
	private  LoggerRepository loggerRepository;

	public void saveLog(String ip, String apiurl, String res) {
	
	LoggerEntity log=new LoggerEntity();
	log.setIpAddress(ip);
	log.setApiUrl(apiurl);
	log.setResponse(res);
	loggerRepository.save(log);
	}
}
