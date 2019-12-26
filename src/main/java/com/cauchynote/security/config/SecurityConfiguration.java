package com.cauchynote.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cauchynote.system.service.impl.UserServiceImpl;
/**
 * 
 * @author Cauchy
 * @ClassName SecurityConfiguration.java
 * @Date 2019年12月26日
 * @Description Spring-Security配置类
 * @Version V1.0
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserServiceImpl userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//			.withUser("user").password(new BCryptPasswordEncoder().encode("123456"))
//			.authorities("ARTICLE_ADD","ARTICLE_UPDATE");
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/article/addArticle").hasAuthority("ARTICLE_ADD")
				.antMatchers("/article/updateArticle").hasAuthority("ARTICLE_UPDATE")
				.antMatchers("/article/deleteArticle").hasAuthority("ARTICLE_DELETE").antMatchers("/article/getArticle")
				.hasAuthority("ARTICLE_QUERY").antMatchers("/**").fullyAuthenticated().and().formLogin()
				// .loginPage("/login")
				.and().csrf().disable();
	}
}
