package com.clustered.data.warehouse.warehouse.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.clustered.data.warehouse.warehouse.entity.DealsDetails;
import com.clustered.data.warehouse.warehouse.payload.DealDetailsDTO;
import com.clustered.data.warehouse.warehouse.repository.DealDetailsRepository;

@Service
public class DealDetailsService {

	private final DealDetailsRepository repository;
	
	public DealDetailsService(DealDetailsRepository repository) {
		this.repository = repository;
	}
	
	public List<DealDetailsDTO> loadDeals() {
		return repository
				.findAll()
				.stream()
				.map(toDtoMapper)
				.collect(Collectors.toList());
	}
	
//	public DealDetailsDTO loadDeal(Integer id) {
//		return repository
//			.findById(id)
//			.map(toDtoMapper)
//			.orElseThrow(()->  new DealNotFoundException(id));
//	}
	
	public String addDealDetails(DealDetailsDTO dto) {
		dto.setId(UUID.randomUUID().toString());
		DealsDetails entity = toEntityMapper.apply(dto);
		entity.setDealTimestamp(LocalDateTime.now());
		DealsDetails entityAdded = repository.save(entity);
		return entityAdded.getId().toString();
	}
	
//	public void updateDealDetails(DealDetailsDTO dto) {
//		DealsDetails oldEntity = repository
//								.findById(dto.getId()).map(d -> d )
//								.orElseThrow(()->  new DealNotFoundException(dto.getId()));
//		
//		DealsDetails newEntity = toEntityMapper.apply(dto);
//		newEntity.setDealTimestamp(oldEntity.getDealTimestamp());
//		
//		repository.save(newEntity);
//	}
	
	
	Function<DealsDetails, DealDetailsDTO> toDtoMapper = 
			entity -> DealDetailsDTO
						.builder()
						.id(entity.getId())
						.dealAmountInOrderingCurrency(entity.getDealAmountInOrderingCurrency())
						.fromCurrencyISOCode(entity.getFromCurrencyISOCode())
						.toCurrencyISOCode(entity.getToCurrencyISOCode())
						.build();
			
	Function<DealDetailsDTO, DealsDetails> toEntityMapper = 
			dto -> DealsDetails
						.builder()
						.id(dto.getId())
						.dealAmountInOrderingCurrency(dto.getDealAmountInOrderingCurrency())
						.fromCurrencyISOCode(dto.getFromCurrencyISOCode())
						.toCurrencyISOCode(dto.getToCurrencyISOCode())
						.build();
	
			

	public void validate(DealDetailsDTO bean) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<DealDetailsDTO>> violations = validator.validate(bean, DealDetailsDTO.class);
		for (ConstraintViolation<DealDetailsDTO> violation : violations) {
			violation.getMessage();
		}
		
	}
}
