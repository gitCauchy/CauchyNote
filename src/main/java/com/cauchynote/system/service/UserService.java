package com.cauchynote.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cauchynote.system.entity.User;
/**
 * 
 * @author Cauchy
 * @ClassName UserService.java
 * @Date 2019年12月26日
 * @Description 用户Service层
 * @Version V1.0
 *
 */
@Service
public interface UserService {
	
	public User getUserById(Long id);

	public void deleteUser(Long id);

	public List<User> getAllUsers();

	public void modifyPassword(User user);

	public void addUser(User user);

	public User findByName(String userName);
}
