package com.cauchynote.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauchynote.user.entity.User;
import com.cauchynote.user.mapper.UserMapper;
import com.cauchynote.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	public User getUserById(Long id) {
		return userMapper.findById(id);
	}

	public void deleteUser(Long id) {
		userMapper.deleteUser(id);
	}

	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	public void modifyPassword(User user) {
		userMapper.modifyPassword(user);
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}
	
}