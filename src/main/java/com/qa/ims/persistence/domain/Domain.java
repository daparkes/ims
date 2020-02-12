package com.qa.ims.persistence.domain;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum Domain {
	
	CUSTOMER("View, create, update or delete customers"),
	ITEM("View, create, update or delete items"),
	ORDER("View, create, update or delete orders"),
	USER("View, create, update or delete users"),
	STOP("Close the application");
	
	public static final Logger LOGGER = Logger.getLogger(Domain.class);
	
	private String description;
	
	private Domain(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	public static void printDomains() {
		for (Domain domain : Domain.values()) {
			LOGGER.info(domain.getDescription());
		}
	}
	
	public static Domain getDomain() {
		Domain domain;
		while (true) {
			try {
				domain = Domain.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection. Please make another.");
			}
		}
		return domain;
	}
}
