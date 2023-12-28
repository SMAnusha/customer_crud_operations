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
import com.customer.dto.AdminDto;
import com.customer.dto.Customer;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher;
@WebServlet("/admin")
public class AdminSignup extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	AdminDto adminDto=new AdminDto();
	String login_id=req.getParameter("login_id");
	String password=req.getParameter("password");
	CustomerDao customerDao=new CustomerDao();
	AdminDto dto=customerDao.foundAdmin(login_id);
	if(dto==null){
	adminDto.setLogin_id(login_id);
	adminDto.setPassword(password);
	customerDao.adminRegister(adminDto);
	resp.sendRedirect("login.html");
	}
	else{
		resp.setContentType("html");
		resp.getWriter().write("<h1>ID exists already pls login</h1>");
	RequestDispatcher dispatcher=req.getRequestDispatcher("Admin.html");
	dispatcher.include(req, resp);
	}
	
	
}
}
