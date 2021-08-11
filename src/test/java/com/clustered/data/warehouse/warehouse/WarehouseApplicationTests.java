package com.clustered.data.warehouse.warehouse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.clustered.data.warehouse.warehouse.exception.ApiError;
import com.clustered.data.warehouse.warehouse.payload.DealDetailsDTO;

import aj.org.objectweb.asm.TypeReference;

@SpringBootTest
class WarehouseApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test() {
	    RestTemplate response = new RestTemplate();
	    ResponseEntity<List<DealDetailsDTO>> exchange = response.exchange("http://localhost:8000/deals", HttpMethod.GET, null, new ParameterizedTypeReference<List<DealDetailsDTO>>() {});
	    List<DealDetailsDTO> dto = exchange.getBody();

	    assert(exchange.getStatusCode() != HttpStatus.OK);
	}

}
