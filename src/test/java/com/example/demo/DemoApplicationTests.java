package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@SpringBootTest
@Controller
class DemoApplicationTests {
	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {

		Page<User> userByPage = userService.findUserByPage(1, 2, "");
		System.out.println(userByPage.getContent());
		System.out.println(userByPage.getTotalPages());
		System.out.println(userByPage.getTotalElements());
	}

}
