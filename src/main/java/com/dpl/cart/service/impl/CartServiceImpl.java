package com.dpl.cart.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dpl.cart.dao.CartDao;
import com.dpl.cart.model.Cart;
import com.dpl.cart.service.CartService;

@Service("CartServiceImpl")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;

	@Override
	public List<Cart> find(String mobile) {
		return cartDao.find(mobile);
	}

	@Override
	public void mergeCart(List<Cart> carts, String mobile) {
		// Find Cart based on mobile
		List<Cart> dbCarts = cartDao.find(mobile);
		if (ObjectUtils.isEmpty(dbCarts)) {
			carts.forEach(cart -> {
				cart.setMobile(mobile);
				cart.setCreatedAt(new Date());
				cart.setUpdatedAt(new Date());
			});
			cartDao.save(carts);
			return;
		}
		Map<String, Cart> dbCartMap = new HashMap<>();
		for (Cart dbCart : dbCarts) {
			String key = dbCart.getPid() + dbCart.getSkuid();
			if (!dbCartMap.containsKey(key)) {
				dbCartMap.put(key, dbCart);
			}
		}
		// Merge Both Cart
		for (Cart cart : carts) {
			// check whether cart already available in db
			String key = cart.getPid() + cart.getSkuid();
			cart.setMobile(mobile);
			Date createDt = dbCartMap.containsKey(key) ? dbCartMap.get(key).getCreatedAt() : new Date();
			cart.setCreatedAt(createDt);
			cart.setUpdatedAt(new Date());
			dbCartMap.put(key, cart);
		}
		List<Cart> mergedCarts = new ArrayList<>();
		dbCartMap.forEach((k, v) -> mergedCarts.add(v));
		cartDao.update(mergedCarts);
	}

	@Override
	public void removeCart(String mobile, Cart cart) {
		cartDao.removeCart(mobile, cart.getPid(), cart.getSkuid());
	}

}
