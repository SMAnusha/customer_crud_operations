package com.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDao;
import com.customer.dto.Customer;
@WebServlet("/fetchall")
public class CustomerList extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CustomerDao customerDao=new CustomerDao();
	List<Customer> list=customerDao.fetchAll();
	req.setAttribute("data", list);
	RequestDispatcher dispatcher=req.getRequestDispatcher("customerList.jsp");
	dispatcher.forward(req, resp);
}
}
