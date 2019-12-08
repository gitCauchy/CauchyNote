package com.cauchynote.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cauchynote.user.entity.User;
import com.cauchynote.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity getUser(@RequestParam(value = "id") Long id) {
		return new ResponseEntity(userService.getUserById(id),HttpStatus.OK);
	}
	
	@GetMapping("/deleteUser")
	public ResponseEntity deleteUser(@RequestParam(value = "id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity getAllUsers() {
		return new ResponseEntity(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/modifyPassword")
	public ResponseEntity modifyPassword(@RequestBody User user) {
		userService.modifyPassword(user);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
}
