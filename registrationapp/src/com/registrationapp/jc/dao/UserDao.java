package com.registrationapp.jc.dao;

import java.util.List;

import com.registrationapp.jc.model.UserEntity;

public interface UserDao {
	public int insertUser(UserEntity user);
	public List<UserEntity> getUsers();

}
