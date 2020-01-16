package com.registrationapp.jc.service;

import java.util.List;

import com.registrationapp.jc.model.UserEntity;

public interface UserService {
	
	public boolean addUser(UserEntity user);
	public List<UserEntity> getUsers();
	public boolean isUserExist(String email, String pass);
}
