package com.qa.TMTY.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.TMTY.controller.LoginAction;
import com.qa.TMTY.controller.LoginController;
import com.qa.TMTY.controller.OrdersAction;
import com.qa.TMTY.controller.OrderController;
import com.qa.TMTY.dao.LoginDAO;
import com.qa.TMTY.dao.OrderDAO;
import com.qa.TMTY.domain.Domain;
import com.qa.TMTY.Utils.DBUtils;
import com.qa.TMTY.Utils.Utils;

public class TMTY {
	
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private final OrderController orders;
	private final LoginController logins;
	private final Utils utils;
	
	public TMTY() {
		this.utils = new Utils();
		final OrderDAO orderDao = new OrderDAO();
		this.orders = new OrderController(orderDao,utils);
		
		final LoginDAO loginDao = new LoginDAO();
		this.logins = new LoginController(loginDao,utils);
		
	}
	
	public void imsSystem() {
		LOGGER.info("Welcome to the Delivery Management System!");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

}
