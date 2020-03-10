package com.dpl.cart.dao;

import java.util.List;

import com.dpl.cart.model.Cart;

public interface CartDao {

	public List<Cart> find(String mobile);

	public void save(List<Cart> carts);

	public void update(List<Cart> carts);

	public void removeCart(String mobile, String pid, String skuid);

}
