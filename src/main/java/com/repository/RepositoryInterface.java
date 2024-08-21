package com.repository;

import java.util.List;

import com.controller.Account;

public interface RepositoryInterface {

	Account checkPassword(int accid,String password);
	int resetPassword(String username, String email, String dob, String password);
	boolean checkAccount(String accid);
	List getReceipientDetails(String accid,String amount);
	void demoCall();
	boolean transaction(int accid,int Raccid,int amount);
}
