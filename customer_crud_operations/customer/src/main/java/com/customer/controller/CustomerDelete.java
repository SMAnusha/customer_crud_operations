package com.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDao;
@WebServlet("/delete")
public class CustomerDelete extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	CustomerDao customerDao=new CustomerDao();
	customerDao.delete(email);
	RequestDispatcher dispatcher=req.getRequestDispatcher("/fetchall");
	dispatcher.forward(req, resp);
	
	
}
}
