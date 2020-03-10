package com.dpl.cart.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpl.cart.model.Cart;
import com.dpl.cart.service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class CartController {

	private static Logger logger = LogManager.getLogger(CartController.class);
	@Autowired
	private CartService cartService;

	@GetMapping(value = "/cart/{mobile}")
	public List<Cart> findCart(@PathVariable String mobile) {
		return cartService.find(mobile);
	}

	@PutMapping("/cart/{mobile}")
	public void mergeCart(@PathVariable("mobile") String mobile, @RequestBody List<Cart> carts) {
		cartService.mergeCart(carts, mobile);
	}

	@DeleteMapping("/cart/{mobile}")
	public String removeCart(@PathVariable String mobile, @RequestBody Cart cart) {
		cartService.removeCart(mobile, cart);
		return "Succuesfull";
	}
}
