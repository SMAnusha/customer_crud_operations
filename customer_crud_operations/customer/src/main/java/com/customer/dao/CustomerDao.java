package com.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.customer.dto.AdminDto;
import com.customer.dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void create(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}

	public void adminRegister(AdminDto adminDto) {
		entityTransaction.begin();
		entityManager.persist(adminDto);
		entityTransaction.commit();
	}

	public AdminDto foundAdmin(String login_id) {
		AdminDto dto = entityManager.find(AdminDto.class, login_id);
		return dto;

	}

	public boolean adminlogin(String login_id, String password) {
		AdminDto adminDto = entityManager.find(AdminDto.class, login_id);

		if (adminDto != null) {
			String login_id1 = adminDto.getLogin_id();
			String password1 = adminDto.getPassword();
			if (login_id.equals(login_id1) && password.equals(password1)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public List<Customer> fetchAll() {
		javax.persistence.Query query = entityManager.createQuery("select a from Customer a");
		List<Customer> list = query.getResultList();
		return list;

	}

	public void delete(String email) {
		Customer customer = entityManager.find(Customer.class, email);
		entityTransaction.begin();
		if (customer != null) {
			entityManager.remove(customer);
		}
		entityTransaction.commit();

	}

	public Customer edit(String email) {
		Customer customer = entityManager.find(Customer.class, email);
		return customer;
	}

	public void update(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
	}
}
