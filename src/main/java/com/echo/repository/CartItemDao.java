package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.models.CartItem;

public interface CartItemDao extends JpaRepository<CartItem, Integer>{

}
