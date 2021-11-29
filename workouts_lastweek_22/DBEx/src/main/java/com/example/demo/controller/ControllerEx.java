package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEx {
	@RequestMapping("/hello")
public String sayhi()
{
	return "hi";
}
}
