package com.aca.springdata.jpaProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Products {

	@Id
	private long PRODUCT_ID;
	private String NAME;
	private Double PRICE;
	@Lob
	private byte[] IMAGE;
	private String DESCRIPTION;
	private long TOTAL_PRODUCTS_INVENTORY;
	private boolean STATUS;

	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Double getPRICE() {
		return PRICE;
	}

	public void setPRICE(Double pRICE) {
		PRICE = pRICE;
	}

	public byte[] getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(byte[] iMAGE) {
		IMAGE = iMAGE;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public long getTOTAL_PRODUCTS_INVENTORY() {
		return TOTAL_PRODUCTS_INVENTORY;
	}

	public void setTOTAL_PRODUCTS_INVENTORY(long tOTAL_PRODUCTS_INVENTORY) {
		TOTAL_PRODUCTS_INVENTORY = tOTAL_PRODUCTS_INVENTORY;
	}

	public boolean isSTATUS() {
		return STATUS;
	}

	public void setSTATUS(boolean sTATUS) {
		STATUS = sTATUS;
	}
	
}
