package com.qa.TMTY.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.TMTY.Utils.Utils;

public enum OrdersAction {
	
	CREATE("To save a new entity into the database"), READ("To read an entity from the database"),
	UPDATE("To change an entity already in the database"), DELETE("To remove an entity from the database"),
	RETURN("To return to the domain selection");
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private String description;
	
	OrdersAction(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	public static void printActions() {
		for (OrdersAction action : OrdersAction.values()) {
			LOGGER.info(action.getDescription());
		}
	}
	
	public static OrdersAction getAction(Utils utils) {
		OrdersAction action = null;
		do {
			try {
				action = OrdersAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (action == null);
		return action;
	}
	

}
