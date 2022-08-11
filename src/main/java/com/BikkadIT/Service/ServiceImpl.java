package com.BikkadIT.Service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceImpl {

	@Autowired
	private SessionFactory sf;
}
