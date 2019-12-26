package com.cauchynote.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Cauchy
 * @ClassName IndexController.java
 * @Date 2019年12月26日
 * @Description Index页面控制层
 * @Version V1.0
 *
 */
@Controller
public class IndexController {
	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
