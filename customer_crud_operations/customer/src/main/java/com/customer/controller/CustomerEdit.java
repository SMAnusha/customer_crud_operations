package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDao;
import com.customer.dto.Customer;
@WebServlet("/edit")
public class CustomerEdit extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String first_name = req.getParameter("first_name");
	String last_name = req.getParameter("last_name");
	String street = req.getParameter("street");
	String address = req.getParameter("address");
	String city = req.getParameter("city");
	String state = req.getParameter("state");
	String email = req.getParameter("email");
	String phone = req.getParameter("phone");
	
	CustomerDao customerDao=new CustomerDao();
	Customer customer=customerDao.edit(email);
	
	customer.setFirst_name(first_name);
	customer.setLast_name(last_name);
	customer.setAddress(address);
	customer.setStreet(street);
	customer.setCity(city);
	customer.setState(state);
	customer.setPhone(phone);
	
	customerDao.update(customer);
	RequestDispatcher dispatcher=req.getRequestDispatcher("/fetchall");
	dispatcher.include(req, resp);
	
	
}
}
