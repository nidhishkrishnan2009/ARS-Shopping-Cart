package com.learning.data.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.data.model.ShoppingCart;
@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Long> {

	public ShoppingCart findByProducts(String products);
	

}
