package com.niit.database.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.database.model.Registration;

@Repository
@Transactional
public class RegistrationDAOImpl implements RegistrationDAO {
	@Autowired
	private SessionFactory sf;

	@Override 
	public void sa(Registration newuser) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().saveOrUpdate(newuser);
	}


}
