package com.langsin.mapper;

import java.util.List;
import java.util.Map;

import com.langsin.pojo.User;

public interface UserMapper {
	public User queryUserByName(Map<String,String> map) throws Exception;
	public User queryUserByEmail(Map<String,String> map) throws Exception;
	
	public void insertUser(User user) throws Exception;

	public List<User> queryListUser() throws Exception;
}
