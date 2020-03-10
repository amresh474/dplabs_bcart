package com.dpl.cart.dao.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dpl.cart.model.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {

}
