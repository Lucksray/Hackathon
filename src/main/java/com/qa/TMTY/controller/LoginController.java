package com.qa.TMTY.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.TMTY.dao.LoginDAO;
import com.qa.TMTY.domain.Login;
import com.qa.TMTY.Utils.Utils;
import com.qa.TMTY.Utils.Generator;

public class LoginController {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private LoginDAO loginDao;
	private Utils utils;
	private Login sign_in;
	
	private Generator generate = new Generator();
	
	public LoginController(LoginDAO loginDao, Utils utils, Login login) {
		this.loginDao = loginDao;
		this.utils = utils;
		this.sign_in = login;
	}
	
	public List<Login> readAll(){
		
		if(this.sign_in.getPrivilege()) {
			List<Login> logins = loginDao.readAll();
			for (Login login : logins) {
				LOGGER.info(login);
			}
		}
	}
	
	public Login create() {
		if (this.sign_in.getPrivilege()) {
			Login login = loginDao.create(new Login(null,null));
		} else {
			LOGGER.info("You don't have privileges to create a login");
			return null;
		}
	}
	
	public Login update() {
		LOGGER.info("Please enter the unique ID of the login entity you want to change");
		Long id = utils.getLong();
		LOGGER.info("Who is the assigner?");
		String assigner = generate.assignerGen();
		LOGGER.info("What is the driver's name?");
		String driver = generate.driverGen();
		
		Login login = loginDao.update(new Login(assigner,driver, id));
	}
	
	public int delete() {
		LOGGER.info("Please enter the unique id of the login entity you would like to delete");
		Long id = utils.getLong();
		try {
			int x = loginDao.delete(id);
			return x;
		} catch (Exception e) {
			LOGGER.error(e);
			return 0;
		}
	}

}
