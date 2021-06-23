package com.clustered.data.warehouse.warehouse.exception;

public class FieldRequiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FieldRequiredException(String fieldName) {
		super(String.format("%s is required", fieldName));
	}

}
