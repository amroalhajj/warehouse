package com.clustered.data.warehouse.warehouse.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "com.clustered.data.warehouse")
public class AllErrorMassages {

	private Map<String, ErrorInfo> errorMsgs = new HashMap<>();
	
	public Optional<ErrorInfo> byClass(AbstractException e) {
		return Optional.ofNullable(errorMsgs
			.get(e.getClass().getSimpleName()));
	}
	
}
