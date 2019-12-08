package com.cauchynote.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cauchynote.user.entity.User;

@Service
public interface UserService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById (Long id);
	
	public void deleteUser(Long id);
	
	public List<User> getAllUsers();
	
	public void modifyPassword(User user);
	
	public void addUser(User user);
}
