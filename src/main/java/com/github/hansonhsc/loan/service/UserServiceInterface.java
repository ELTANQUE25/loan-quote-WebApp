package com.github.hansonhsc.loan.service;

import java.util.List;

import com.github.hansonhsc.loan.model.User;


public interface UserServiceInterface {


public List<User> getUsers();

public User getUserByUsername(String username);

}
