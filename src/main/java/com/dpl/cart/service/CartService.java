package com.dpl.cart.service;

import java.util.List;

import com.dpl.cart.model.Cart;

public interface CartService {

	public void mergeCart(List<Cart> dbCarts, String mobile);

	public List<Cart> find(String mobile);

	public void removeCart(String mobile, Cart cart);

}
