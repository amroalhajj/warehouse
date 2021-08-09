package com.clustered.data.warehouse.warehouse.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clustered.data.warehouse.warehouse.payload.DealDetailsDTO;
import com.clustered.data.warehouse.warehouse.service.DealDetailsService;

@RestController
@RequestMapping("/deals")
public class DealsDetailsController {

	private final DealDetailsService dealsService;
	
	public DealsDetailsController(DealDetailsService dealsService) {
		this.dealsService = dealsService;
	}
	
	@GetMapping
	public ResponseEntity<List<DealDetailsDTO>> loadDeals() {
		return ResponseEntity.ok(dealsService.loadDeals());
	}
	
	@PostMapping
	public String addDealDetails (@RequestBody @Validated DealDetailsDTO dto) {
		return dealsService.addDealDetails(dto);
	}
}
