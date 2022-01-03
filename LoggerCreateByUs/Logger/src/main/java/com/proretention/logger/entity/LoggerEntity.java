package com.proretention.logger.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@Entity
public class LoggerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loggerId;
	private String ipAddress;
	private String apiUrl;
	private final LocalDateTime Time = LocalDateTime.now();
	private String response;
	
}
