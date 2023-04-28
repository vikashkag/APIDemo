package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {


	@Autowired
	private ServiceImp serviceImp;
	
	@GetMapping("/get")
	public List<DataWrapper> getData() {
		return serviceImp.getData();
	}
	
}
