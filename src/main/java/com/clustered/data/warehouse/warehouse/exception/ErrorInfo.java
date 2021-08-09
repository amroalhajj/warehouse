package com.clustered.data.warehouse.warehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

	private int errorCode;
	
	private int restStatus;
	
	private String msg;
	
}
