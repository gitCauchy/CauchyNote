package com.cauchynote.system.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
 * 
 * @author Cauchy
 * @ClassName User.java
 * @Date 2019年12月26日
 * @Description 用户实体类,实现了UserDetails 接口，用于Spring-security 用户鉴权。
 * @Version V1.0
 *
 */
@Data
public class User implements UserDetails {
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
	private Date createTime;
	/*
	 * 账号是否过期
	 */
	private Integer isExpired;
	/*
	 * 账号是否被锁定
	 */
	private Integer isLocked;
	/*
	 * 密码是否过期
	 */
	private Integer isPasswordExpired;
	/*
	 * 是否可用
	 */
	private Integer isEnable;

	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	/**
	 * @description 返回用户权限
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	/**
	 * @description 复写父类方法，返回isExpired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return checkStatus(isExpired);
	}

	/**
	 * @description 复写父类方法，返回isLocked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return checkStatus(isLocked);
	}

	/**
	 * @description 复写父类方法，返回isCredentialsNonExpired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return checkStatus(isPasswordExpired);
	}

	/**
	 * @description 复写父类方法，返回isEnable
	 */
	@Override
	public boolean isEnabled() {
		return checkStatus(isEnable);
	}

	/**
	 * 
	 * @param rawStatus Integer 类型状态码
	 * @return boolean 类型状态码
	 * @Description 将Integer类型状态码转换为父类方法所需要的boolean类型
	 */
	private boolean checkStatus(Integer rawStatus) {
		return rawStatus.equals(0) ? true : false;
	}
}
