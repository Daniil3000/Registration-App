package com.registrationapp.jc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registrationapp.jc.dao.UserDao;
import com.registrationapp.jc.model.UserEntity;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public boolean addUser(UserEntity user) {
		return userDao.insertUser(user)>0;
	}

	@Override
	@Transactional
	public List<UserEntity> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public boolean isUserExist(String email, String pass) {
		List<UserEntity> users = this.getUsers();
		boolean result = false;
		for (UserEntity dbUser : users) {
			if (dbUser.getEmail().equals(email) && dbUser.getPass().equals(pass)) {
				result = true;				
			}	
		}
		return result;
	}

}
