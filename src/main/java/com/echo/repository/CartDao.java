package com.echo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echo.models.Cart;
import com.echo.models.Product;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer> {

//	public Map<Product,Integer> findbyName(String productName);
//	public Cart findbyId(Integer cartId);
}
