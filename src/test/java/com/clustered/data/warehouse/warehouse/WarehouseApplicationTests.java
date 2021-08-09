package com.clustered.data.warehouse.warehouse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.clustered.data.warehouse.warehouse.exception.ApiError;
import com.clustered.data.warehouse.warehouse.payload.DealDetailsDTO;

@SpringBootTest
class WarehouseApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void test() {
//	    RestTemplate response = new RestTemplate();
//	    	response.exchange(, HttpMethod.GET, DealDetailsDTO.class);
//	    ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("should be of type"));
//	}
	
//	@Test
//	public void whenMethodArgumentMismatch_thenBadRequest() {
//	    Response response = givenAuth().get("http://localhost:8000/deals");
//	    ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("should be of type"));
//	}

}
