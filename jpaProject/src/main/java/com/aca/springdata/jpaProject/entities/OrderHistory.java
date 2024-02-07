package com.aca.springdata.jpaProject.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDER_HISTORY")
public class OrderHistory {

	@Id
	private long ORDER_ID;
	private Timestamp ORDER_DATE;
	private long USER_ID;
	private long PRODUCT_ID;

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

	public long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}

	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
}
