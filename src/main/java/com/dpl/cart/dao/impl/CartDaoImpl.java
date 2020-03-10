package com.dpl.cart.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.dpl.cart.dao.CartDao;
import com.dpl.cart.model.Cart;

@Repository("CartDaoImpl")
public class CartDaoImpl implements CartDao {
	@Autowired
	private MongoTemplate template;
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> find(String mobile) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile));
		return template.find(query, Cart.class);
	}

	@Override
	public void save(List<Cart> carts) {
		template.insert(carts, Cart.class);
	}

	@Override
	public void update(List<Cart> carts) {
		cartRepository.saveAll(carts);
	}

	@Override
	public void removeCart(String mobile, String pid, String skuid) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile));
		if (!ObjectUtils.isEmpty(pid)) {
			query.addCriteria(Criteria.where("pid").is(pid));
		}
		if (!ObjectUtils.isEmpty(skuid)) {
			query.addCriteria(Criteria.where("skuid").is(skuid));
		}
		template.remove(query, Cart.class);
	}

}
