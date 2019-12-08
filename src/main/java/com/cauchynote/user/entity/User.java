package com.cauchynote.user.entity;

import java.security.Timestamp;

import lombok.Data;

@Data
public class User {
	/*
	 * ID
	 */
	private Long id;
	/*
	 * 用户名
	 */
	private String userName;
	/*
	 * 电子邮箱
	 */
	private String email;
	/*
	 * 密码
	 */
	private String password;
	/*
	 * 创建时间
	 */
	private Timestamp createTime;
	/*
	 * 用户状态
	 */
	private Integer status;
}
