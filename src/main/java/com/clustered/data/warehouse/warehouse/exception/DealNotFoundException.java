package com.clustered.data.warehouse.warehouse.exception;


public class DealNotFoundException extends AbstractException {
	
	public DealNotFoundException(Integer id) {
		super(id+"");
	}
	
}
