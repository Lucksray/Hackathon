package com.qa.TMTY.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.TMTY.Utils.Utils;

public enum LoginAction {
	
	CREATE("To save a new login entity into the database"), READ("To be able to see all current login entities"),
	DELETE("To drop a single entity from the database"), RETURN("To return to the domain selection");
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private String description;
	
	LoginAction(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	public static void printActions() {
		for (LoginAction action : LoginAction.values()) {
			LOGGER.info(action.getDescription());
		}
	}
	
	public static LoginAction getAction(Utils utils) {
		LoginAction action = null;
		do {
			try {
				action = LoginAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection, please try again");
			}
		}while (action == null);
		return action;
	}
	
	

}
