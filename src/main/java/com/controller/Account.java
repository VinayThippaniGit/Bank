package com.controller;

import java.util.Date;

public class Account {

	private static String username ;
	private static int accid ;
	private static String email ;
	private static String password ;
	private static int balance ;
	private static Date dob;
	
	public Account(String username , int accid , String email , int balance , Date dob) {
		username = this.username;
		accid=this.accid;
		email=this.email;
		balance=this.balance;
		this.dob=dob;
	}
	
	public Account() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob=dob;
	}
	
	
	
}
