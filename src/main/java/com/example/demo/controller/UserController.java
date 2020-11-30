package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//        分页查询
    @GetMapping("/page")
    public Page<User> findPage(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               @RequestParam(required = false) String name){
        Page<User> userByPage = userService.findUserByPage(currentPage, pageSize, name);
        List<User> users = userByPage.getContent();
        int totalElements = (int) userByPage.getTotalElements();
        int totalPages = userByPage.getTotalPages();
       return userByPage;
    }
}
