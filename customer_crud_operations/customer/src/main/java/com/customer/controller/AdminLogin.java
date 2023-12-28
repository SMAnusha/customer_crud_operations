package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDao;
@WebServlet("/login")
public class AdminLogin extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String login_id = req.getParameter("login_id");
	String password = req.getParameter("password");
	PrintWriter out = resp.getWriter();
	resp.setContentType("text/html");
	CustomerDao customerDao = new CustomerDao();
	boolean flag = customerDao.adminlogin(login_id, password);
	if (flag) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/fetchall");
		dispatcher.include(req, resp);
	} else {
		out.println("Incorrect username or password");
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
		dispatcher.include(req, resp);
	}
}
}

