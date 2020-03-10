package com.dpl.cart.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document("dpl_cart")
public class Cart implements Serializable {
	private static final long serialVersionUID = -5628664968903021377L;
	@Id
	private String id;
	@Indexed
	private String mobile;
	private String pid;
	private String skuid;
	private String cartid;

	private String price;
	private String qty;

	@JsonIgnore
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;
	@JsonIgnore
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedAt;

}
