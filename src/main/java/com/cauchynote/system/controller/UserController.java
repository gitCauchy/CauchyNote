package com.cauchynote.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cauchynote.system.entity.User;
import com.cauchynote.system.service.UserService;
/**
 * 
 * @author Cauchy
 * @ClassName UserController.java
 * @Date 2019年12月26日
 * @Description 用户控制层
 * @Version V1.0
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestParam(value = "id") Long id) {
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@GetMapping("/deleteUser")
	public ResponseEntity<HttpStatus> deleteUser(@RequestParam(value = "id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/modifyPassword")
	public ResponseEntity<HttpStatus> modifyPassword(@RequestBody User user) {
		userService.modifyPassword(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
}
