package com.clustered.data.warehouse.warehouse.validation;

import java.util.logging.Logger;

import com.clustered.data.warehouse.warehouse.exception.FieldRequiredException;

public class Validator {
		
	Logger logger    = Logger.getLogger(Validator.class.getName());
	
	public boolean isEmpty(String str) throws FieldRequiredException{
		if (str == null || str.isEmpty() || str.trim().isEmpty()) { 
			logger.info("This field is empty!");
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
