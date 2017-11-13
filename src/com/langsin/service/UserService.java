package com.langsin.service;

import java.util.List;

import com.langsin.pojo.User;

public interface UserService {
	public User queryUser(String email,String pass) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public List<User> queryUserList() throws Exception;
}
