package com.cauchynote.system.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * 
 * @author Cauchy
 * @ClassName Role.java
 * @Date 2019年12月26日
 * @Description 角色实体类
 * @Version V1.0
 *
 */
@Data
public class Role implements Serializable {

	private static final long serialVersionUID = 5108236336492034573L;
	/*
	 * 角色ID
	 */
	private Long id;
	/*
	 * 角色名称
	 */
	private String roleName;
	/*
	 * 角色描述
	 */
	private String roleDesc;
}
