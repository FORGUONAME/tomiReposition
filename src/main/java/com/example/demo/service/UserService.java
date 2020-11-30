package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> findUserByPage(int currentPage, int pageSize, String name);
}
