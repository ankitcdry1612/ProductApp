package com.rakuten.training.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;

@Service
public class SomeSpecialUseCaseService {
	@Autowired
	@Qualifier("productDAOInMemImpl")
	ProductDAO dao;
	
	@PostConstruct
	public void playWithDAO() {
		System.out.println("<<<<<<<Type of dao in SomeSpecialUseCaseService "+dao.getClass().getName());
	}
}
