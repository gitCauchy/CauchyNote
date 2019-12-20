package com.cauchynote.user.mapper;

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

import com.cauchynote.user.entity.User;

@Repository
public interface UserMapper {
	
	@Select("select * from user where id = #{id}")
	User findById(Long id);
	@Select("select * from user")
	@Results(id="id",value = {
		@Result(column = "user_name",property = "userName",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(column = "email",property = "email",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(column = "password",property = "password",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(column = "createTime",property = "create_time",javaType = Date.class,jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "status",property = "status",javaType = Integer.class,jdbcType = JdbcType.BIGINT)})
	List<User> getAllUsers();
	
	@Insert("insert into user(user_name,email,password,status) values(#{userName},#{email},#{password},#{status}")
	@Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
	void addUser(User user);
	
	@Update("update user set password = #{password} where user.id = #{id}")
	void modifyPassword(User user);
	
	@Delete("delete from user where id = #{id}")
	void deleteUser(Long id);
	
	@Select("select * from user where name = #{userName}")
	User findByName(String userName);
	
}	
