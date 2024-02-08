package com.aca.springdata.jpaProject.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_HISTORY")
public class OrderHistory {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ORDER_ID;
	private Timestamp ORDER_DATE;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Products product;

	public long getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(long oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public Timestamp getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(Timestamp oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
}
