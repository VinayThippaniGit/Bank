package com.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.controller.Account;

@Repository("r")
public class RepositoryImpl implements RepositoryInterface {

	@Autowired
	private JdbcTemplate jt;

	public void demoCall() {
		System.out.println(jt);
		System.out.println(jt.getDataSource());
		System.out.println(jt.update("insert into accountdetails (accid) values(3)"));
		System.out.println("Done");
	}

	@Override
	public Account checkPassword(int accid, String password) {
		return jt.query("select * from Accountdetails where accid=" + accid + " AND password='" + password + "'",
				new ResultSetExtractor<Account>() {
					@Override
					public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
						Account a = null;
						if (rs.next()) {
							a=new Account();
							a.setAccid(rs.getInt("accid"));
							a.setBalance(rs.getInt("balance"));
							a.setEmail(rs.getString("email"));
							a.setUsername(rs.getString("username"));
							a.setPassword(rs.getString("password"));
						}

						return a;
					}

				});
	}

	public int resetPassword(String username, String email, String dob, String password) {
		int result = jt.update("update AccountDetails set password=? where username=? and email=? and dob=?",
				new Object[] { password, username, email, dob });
		return result;
	}

	@Override
	public boolean checkAccount(String accid) {
		return jt.query("select * from accountdetails where accid=" + accid, new ResultSetExtractor<>() {
			boolean checkAccount = false;

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					checkAccount = true;
				}
				return checkAccount;
			}

		});

	}

	@Override
	public List getReceipientDetails(String accid, String amount) {
		return jt.query("select * from accountdetails where accid=" + accid, new ResultSetExtractor<>() {
			List a = new ArrayList();

			@Override
			public List extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					a.add(rs.getInt("accid"));
					a.add(rs.getString("username"));
					a.add(rs.getInt("balance"));
				}
				return a;
			}

		});

	}

	@Override
	public boolean transaction(int accid,int Raccid,int amount) {
		
		int count1 = jt.update("update accountdetails set balance=balance-"+amount+" where accid="+accid);
		int count2=jt.update("update accountdetails set balance=balance+"+amount+" where accid="+Raccid);
		
		if(count1+count2==2) {
			return true;
		}
		return false;
	}

}
