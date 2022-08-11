package com.BikkadIT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Service.ServiceImpl;

@RestController
public class PetientController {

	@Autowired
	private ServiceImpl serviceImpl;
}
