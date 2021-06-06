package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MockOrder;
import com.example.demo.repository.MockOrderRepository;

@Service
public class MockOrderService {
	
	@Autowired
	MockOrderRepository mockOrderrepository;
	
	public Optional<MockOrder> getMockOrderStatusById(String id) {
		return mockOrderrepository.findById(id);
	}
	
	public String addMockOrder(MockOrder order) {
		order = mockOrderrepository.save(order);
		return order.getId();
	}
	
	
}
