package com.clustered.data.warehouse.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clustered.data.warehouse.warehouse.entity.DealsDetails;

@Repository
public interface DealDetailsRepository extends JpaRepository<DealsDetails, Integer>{

}
