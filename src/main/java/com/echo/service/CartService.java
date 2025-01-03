package com.echo.service;

import java.util.List;

import com.echo.controller.ProductNotFound;
import com.echo.exception.CartItemNotFound;
import com.echo.models.Cart;
import com.echo.models.CartDTO;
import com.echo.models.CartItem;




public interface CartService {
	
	public Cart addProductToCart(CartDTO cart, String token) throws CartItemNotFound;
	public Cart getCartProduct(String token);
	public Cart removeProductFromCart(CartDTO cartDto,String token) throws ProductNotFound;
//	public Cart changeQuantity(Product product,Customer customer,Integer quantity);
	
	public Cart clearCart(String token);
	
}
