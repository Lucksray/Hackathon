package com.qa.TMTY.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.TMTY.dao.OrderDAO;
import com.qa.TMTY.domain.Login;
import com.qa.TMTY.domain.Orders;
import com.qa.TMTY.Utils.Utils;
import com.qa.TMTY.Utils.Generator;

public class OrderController {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDao;
	private Utils utils;
	private Login sign_in;
	
	private Generator generate = new Generator();
	
	public OrderController(OrderDAO orderDao, Utils utils, Login login) {
		this.orderDao = orderDao;
		this.utils = utils;
		this.sign_in = login;
	}
	
	public List<Orders> readAll(){
		
		if (this.sign_in.getPrivilege()) {
			List<Orders> orders = orderDao.readAll();
			for (Orders order : orders) {
				LOGGER.info(order);
			}
		}
	}
	
	public Orders create() {
		LOGGER.info("What is the order id?");
		Long packageId = generate.packageIdGen();
		LOGGER.info("What is the order address");
		String address = utils.getString();
		
		Orders order = orderDao.create(new Orders(address, packageId));
		
		return order;		
	}
	
	public Orders update() {
		LOGGER.info("Please enter the unique ID of the order you would like to update");
		int id = utils.getInt();
		LOGGER.info("Please enter the new address");
		String address = utils.getString();
		LOGGER.info("Please enter the new package ID");
		Long packageId = generate.packageIdGen();
		
		Orders order = orderDao.update(new Orders(id,address,packageId));
		
	}
	
	public int delete() {
		LOGGER.info("Please enter the unique id of the order you would like to delete");
		int id = utils.getInt();
		
		try {
			int x = orderDao.delete(id);
			return x;
		} catch (Exception e) {
			LOGGER.error(e);
			return 0;
		}
	}

}
