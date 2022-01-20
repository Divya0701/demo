package com.CodeBuffer.SpringBootTute1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String hello() {
		return "hell";
	}
}
