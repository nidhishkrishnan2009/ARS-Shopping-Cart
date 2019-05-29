package com.learning.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.data.model.ShoppingCart;
import com.learning.data.repository.CartRepository;

@RestController
public class CartController {

	@Autowired
	private CartRepository cartRepo;
	
	@GetMapping(value="/test")
	public String printTest()
	{
		return "test";
	}
	
	@PostMapping(value="/addInventory")
	public ResponseEntity<?> addInventory(@RequestBody ShoppingCart cart )
	{
		if(cartRepo.findByProducts(cart.getProducts())!=null)
			return new ResponseEntity<>("Not saved due to duplicate product name",HttpStatus.INTERNAL_SERVER_ERROR);
			
		cartRepo.save(cart);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/updateInventory")
	public ResponseEntity<?> updateInventory(@RequestParam String productName,@RequestParam String quantityToBeInserted)
	{
		ShoppingCart cart=cartRepo.findByProducts(productName);
		if(cart==null)
			return new ResponseEntity<>("No product with given name have been found",HttpStatus.OK);
		cart.setQuantity(quantityToBeInserted);
		cartRepo.save(cart);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	
	

	
	@GetMapping(value="/listInventory")
	
	public ResponseEntity<?> listInventory()
	{
		List<ShoppingCart> cart=cartRepo.findAll();
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	
}
