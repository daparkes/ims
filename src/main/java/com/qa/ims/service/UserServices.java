package com.qa.ims.service;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.User;

public class UserServices implements CrudServices<User> {
	
	Dao<User> userDao;
	
	public UserServices(Dao<User> userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> readAll(){
		return userDao.readAll();
	}
		
	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);		
	}
}