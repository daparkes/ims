package com.qa.ims.controller;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum Action {
	
	CREATE("Save a new item in the database."),
	READ("View an item in the database."),
	UPDATE("Change an existing item in the database."),
	DELETE("Remove an item from the database."),
	RETURN("Return to section select.");
	
	public static final Logger LOGGER = Logger.getLogger(Action.class);
	
	private String description;
	
	private Action() {
	}
	
	Action(String description) {
		this.description = description;
	}
	
	/**
	 * Describes the action.
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	/**
	 * Prints out all possible actions.
	 */
	
	public static void printActions() {
		for (Action action : Action.values()) {
			LOGGER.info(action.getDescription());
		}
	}
	
	/**
	 * Chooses an action based on user input.
	 * @return
	 */
	
	public static Action getAction() {
		Action action;
		while (true) {
			try {
				action = Action.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection. Please try again.");
			}
		}
		return action;
	}
}