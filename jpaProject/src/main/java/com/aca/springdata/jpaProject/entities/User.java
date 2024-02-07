package com.aca.springdata.jpaProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	private long USER_ID;
	private String NAME;
	private String LAST_NAME;
	private String BIO;
	private String EMAIL;
	private String AREA_OF_INTEREST;

	public long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getBIO() {
		return BIO;
	}

	public void setBIO(String bIO) {
		BIO = bIO;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getAREA_OF_INTEREST() {
		return AREA_OF_INTEREST;
	}

	public void setAREA_OF_INTEREST(String aREA_OF_INTEREST) {
		AREA_OF_INTEREST = aREA_OF_INTEREST;
	}

}
