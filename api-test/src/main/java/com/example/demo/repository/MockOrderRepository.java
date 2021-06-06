package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.MockOrder;

public interface MockOrderRepository extends CrudRepository<MockOrder, String> {
	Optional<MockOrder> findById(String id);
	
	MockOrder findByPrice(double id);
	
	<S extends MockOrder> S save(S entity);
}
