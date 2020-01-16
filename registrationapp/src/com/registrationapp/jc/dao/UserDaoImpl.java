package com.registrationapp.jc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.registrationapp.jc.model.UserEntity;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int insertUser(UserEntity user) {
		sessionFactory.getCurrentSession().save(user);
		return 1;
	}

	@Override
	public List<UserEntity> getUsers() {
		return getSession().createQuery("from UserEntity", UserEntity.class).list();
	}


}
