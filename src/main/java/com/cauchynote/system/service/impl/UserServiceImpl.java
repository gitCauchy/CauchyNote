package com.cauchynote.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cauchynote.system.entity.Permission;
import com.cauchynote.system.entity.User;
import com.cauchynote.system.mapper.UserMapper;
import com.cauchynote.system.service.UserService;
/**
 * 
 * @author Cauchy
 * @ClassName UserServiceImpl.java
 * @Date 2019年12月26日
 * @Description UserService实现类，同时实现了UserDetailsService,用于SpringSecurity鉴权
 * @Version 
 *
 */
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	private Logger log = Logger.getLogger(UserServiceImpl.class);
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

	public User findByName(String userName) {
		return userMapper.findByName(userName);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userMapper.findByName(username);
		log.info(user);
		// 查询用户的所有权限
		List<Permission> permissions = userMapper.findPermissionByName(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Permission perm : permissions) {
			GrantedAuthority authority = new SimpleGrantedAuthority(perm.getPermissionTag());
			authorities.add(authority);
		}
		// 把所有权限赋值给user
		user.setAuthorities(authorities);
		return user;
	}
}
