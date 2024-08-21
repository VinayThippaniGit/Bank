package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.controller.Account;
import com.repository.RepositoryImpl;
import com.repository.RepositoryInterface;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
@WebServlet(name = "l", urlPatterns = { "/login", "/transferMoney", "/verify" })
public class LoginCheck extends HttpServlet {
	
	@Autowired
	static RepositoryInterface r;
	static {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		r = context.getBean(RepositoryImpl.class);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getServletPath().equals("/login")) {
			login(req, res);
		} else if (req.getServletPath().equals("/transferMoney")) {
			transferMoney(req, res);
		} else if (req.getServletPath().equals("/verify")) {
			verify(req, res);
		}
	}

	protected void login(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		int accid = Integer.parseInt(req.getParameter("accid"));
		String password = req.getParameter("password");
		Account ac= r.checkPassword(accid, password);
		if (ac==null) {
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			PrintWriter writer = res.getWriter();
			writer.println(
					"<html><body><br><center><h4 style='color:red;'>*Invalid Details</h4></center></body></html>");
			rd.include(req, res);
		} else {
			req.getSession().setAttribute("AccountDetails", ac);
			
			RequestDispatcher rd = req.getRequestDispatcher("/loginPage.jsp");
			rd.forward(req, res);

		}
	}

	private void transferMoney(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Account ac = (Account) req.getSession().getAttribute("AccountDetails");
		
		String ra = req.getParameter("recipientAccountNumber");
		boolean checking = r.checkAccount(ra);

		String amount = req.getParameter("amount");
		if (checking) {
			List rd = r.getReceipientDetails(ra, amount);
			req.setAttribute("recipientAccountNumber", rd.get(0));
			req.setAttribute("recipientName", rd.get(1));
			req.setAttribute("amount", amount);
			
			req.getRequestDispatcher("/verifying.jsp").forward(req, res);
			
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/transferMoney.jsp");
			res.getWriter().println(
					"<html><body><br><center><h4 style='margin-top:0px;color:red;'>*No user found for that account number</h4></center></body></html>");
			rd.include(req, res);
		}
	}

	private void verify(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		Account ac = (Account) req.getSession().getAttribute("AccountDetails");
			
		int Raccid = Integer.parseInt(req.getParameter("recipientAccountNumber"));
		String ps = req.getParameter("password");
		int amount = Integer.parseInt(req.getParameter("amount"));
		PrintWriter writer = res.getWriter();
		if (ac.getPassword().equals(ps)) {
			boolean transaction = r.transaction(ac.getAccid(), Raccid, amount);
			if(transaction) {
				ac = r.checkPassword(ac.getAccid(), ac.getPassword());
				req.getSession().setAttribute("AccountDetails", ac);
				req.getRequestDispatcher("/TransactionSuccessful.jsp").forward(req, res);
			}
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/transferMoney.jsp");
			writer.println(
					"<html><body><br><center><h4 style='color:red;'>*Transaction unsuccesfull , Incorrect password. Please Try again</h4></center></body></html>");
			rd.include(req, res);
		}

	}

}
