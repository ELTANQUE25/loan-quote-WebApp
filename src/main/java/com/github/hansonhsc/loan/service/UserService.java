package com.github.hansonhsc.loan.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.hansonhsc.loan.dao.IUserDao;
import com.github.hansonhsc.loan.model.User;



@Transactional
public class UserService implements UserServiceInterface {


	IUserDao userDao;



	@Transactional
	public List<User> getUsers(){
		return getUserDao().getUsers();
	}


	@Transactional
	public User getUserByUsername(String username){
		return getUserDao().getUserByUsername(username);
	}


	public IUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


}



