package com.niit.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.database.dao.RegistrationDAO;
import com.niit.database.model.Registration;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationDAO rd;
		
		@Override
		public void save(Registration registration) {
			// TODO Auto-generated method stub
			rd.sa(registration);

	}



}
