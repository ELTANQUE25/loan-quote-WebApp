package com.github.hansonhsc.loan.dao;


import java.util.List;

import com.github.hansonhsc.loan.model.User;



public interface IUserDao {
public List<User> getUsers();

public User getUserByUsername(String username);

	
}
