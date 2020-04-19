package com.github.hansonhsc.loan.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

/**
 * Bean to represent lenders specified in the input CSV file
 */
@Entity
@Table(name = "users")
public final class User {
    /**
     * the name of the lender
     */
	
	@Id
	@Column(name="iduser")
	private int iduser;
	
	@Column(name= "username")
    private String username;

    /**
     * the annual interest rate of any loans by this lender
     */
	@Column(name= "password")
    private String password;

	
	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
