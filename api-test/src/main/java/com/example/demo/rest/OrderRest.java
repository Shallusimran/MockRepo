package com.example.demo.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MockOrder;
import com.example.demo.service.MockOrderService;

@RestController
public class OrderRest {
	
	@Autowired
	MockOrderService mockOrderService;
	
	@GetMapping
	@RequestMapping("/")
	public String hello() {
		return  "Hello World";
	} 
	
	@GetMapping
	@RequestMapping(value="/order-status/{id}",method=RequestMethod.GET)
	public Map<String,Object> getOrderStatus(@PathVariable("id")String id) {
		HashMap<String,Object> answer = new HashMap<String,Object>();
		MockOrder order;
		try {
			order = mockOrderService.getMockOrderStatusById(id).get();
		} catch (Exception MockOrder) {
			order = new MockOrder(id, "Null","Null","Null");
			order.setPrice(0.0);
		}
		
		answer.put("Status", order.getStatus());
		answer.put("Price" , order.getPrice());
		return answer;
	}
	
	
	@PostMapping(value="/place-order",consumes = { "application/json" })
	public String placeOrder(@RequestBody Map<String, Object> requestBody) {
		MockOrder order = new MockOrder();
		Map<String, Object> mapeo = (Map<String, Object>) requestBody.get("authdata");
		String randomOrderID = RandomStringUtils.randomAlphanumeric(8)+"-"+RandomStringUtils.randomAlphanumeric(4)+"-"+RandomStringUtils.randomAlphanumeric(4)+"-"+RandomStringUtils.randomAlphanumeric(12)  ;
		
		order.setId(randomOrderID);
		//By default status is pending
		order.setStatus("Pending");
		order.setOrder_type( (String) mapeo.get("order_type"));	
		order.setSecurity( (String) mapeo.get("security"));	
		order.setPrice(0.0);
		
		return mockOrderService.addMockOrder(order);
	}
}
