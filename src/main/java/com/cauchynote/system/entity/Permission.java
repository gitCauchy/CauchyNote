package com.cauchynote.system.entity;

import java.io.Serializable;

import lombok.Data;
/**
 * 
 * @author Cauchy
 * @ClassName Permission.java
 * @Date 2019年12月26日
 * @Description 权限实体类
 * @Version V1.0
 *
 */
@Data
public class Permission implements Serializable{
	
	private static final long serialVersionUID = -1560013677076588842L;
	/*
	 * 权限ID
	 */
	private Long id;
	/*
	 * 权限名称
	 */
	private String permissionName;
	/*
	 * 权限标签
	 */
	private String permissionTag;
}
