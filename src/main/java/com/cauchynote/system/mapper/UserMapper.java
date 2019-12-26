package com.cauchynote.system.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.cauchynote.system.entity.Permission;
import com.cauchynote.system.entity.User;

/**
 * 
 * @author Cauchy
 * @ClassName UserMapper.java
 * @Date 2019年12月26日
 * @Description 用户持久层Mapper，提供用户CRUD以及鉴权行为操作。
 * @Version V1.0
 *
 */
@Repository
public interface UserMapper {
	/**
	 * @param id
	 * @return User 
	 * @Description 根据id 查询用户
	 */
	@Select("select * from user where id = #{id}")
	User findById(Long id);
	/**
	 * 
	 * @return List
	 * @Description 查询所有用户
	 */
	@Select("select * from user")
	@Results(id = "getAll", value = {
			@Result(column = "id", property = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "user_name", property = "userName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "is_expired", property = "isExpired", javaType = Integer.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "is_locked", property = "isLocked", javaType = Integer.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "is_password_expired", property = "isPasswordExpired", javaType = Integer.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "is_enable", property = "isEnable", javaType = Integer.class, jdbcType = JdbcType.BIGINT)})
	List<User> getAllUsers();
	/**
	 * 
	 * @param user
	 * @Description 新增用户
	 */
	@Insert("insert into user(user_name,email,password,status) values(#{userName},#{email},#{password},#{status}")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void addUser(User user);
	/**
	 * 
	 * @param user
	 * @Description 修改密码
	 */
	@Update("update user set password = #{password} where user.id = #{id}")
	void modifyPassword(User user);
	/**
	 * 
	 * @param id
	 * @Description 删除用户
	 */
	@Delete("delete from user where id = #{id}")
	void deleteUser(Long id);
	/**
	 * 
	 * @param userName
	 * @return
	 * @Description 根据用户名查询用户
	 */
	@Select("select * from user where user_name = #{userName}")
	@Results(id = "getByName", value = {
			@Result(column = "id", property = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "user_name", property = "userName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "is_expired", property = "isExpired", javaType = Integer.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "is_locked", property = "isLocked", javaType = Integer.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "is_password_expired", property = "isPasswordExpired", javaType = Integer.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "is_enable", property = "isEnable", javaType = Integer.class, jdbcType = JdbcType.BIGINT) })
	User findByName(String userName);
	/**
	 * 
	 * @param userName
	 * @return
	 * @Description 用户权限查询
	 */
	@Select("select permission.* from user inner join user_role on user.id = user_role.user_id inner "
			+ "join role_permission on user_role.role_id = role_permission.role_id "
			+ "inner join permission on role_permission.permission_id = permission.id "
			+ "where user_name = #{user_name}")
	@Results({ @Result(column = "id", property = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(column = "permission_name", property = "permissionName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "permission_tag", property = "permissionTag", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	List<Permission> findPermissionByName(String userName);
}
