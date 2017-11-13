package com.langsin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.langsin.mapper.UserMapper;
import com.langsin.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper = null;
	
	@Override
	public User queryUser(String email, String pass) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("email", email);
		map.put("pass", pass);
		return userMapper.queryUserByEmail(map);
	}

	public List<User> queryUserList() throws Exception{
		return userMapper.queryListUser();
	}

	@Override
	public void insertUser(User user) throws Exception {
		 userMapper.insertUser(user);
	}
}
