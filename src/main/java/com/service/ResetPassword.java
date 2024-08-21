package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.repository.RepositoryImpl;
import com.repository.RepositoryInterface;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
@WebServlet(name="rp" , urlPatterns="/ResetPassword")
public class ResetPassword extends HttpServlet{
	
	@Autowired
	static RepositoryInterface r;
	static {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		r = context.getBean(RepositoryImpl.class);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email=req.getParameter("email");
		String dob=req.getParameter("dob");
		String password=req.getParameter("password");
		
		int result = r.resetPassword(username,email,dob,password);
		PrintWriter writer = res.getWriter();
		if(result == 1) {
			RequestDispatcher rd = req.getRequestDispatcher("/PersonalBanking.html");
			writer.println("<html><body><center><h3 style='display:absolute; margin-top:0px;color:green;'>Succesfully Changed</h3></center></body></html>");
			rd.include(req, res);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/ForgotPassword.html");
			writer.println("<html><body><br><center><h4 style='display:absolute; margin-top:0px;color:red;'>*Invalid Details</h4></center></body></html>");
			rd.include(req,res);
		}
	}

	
}
