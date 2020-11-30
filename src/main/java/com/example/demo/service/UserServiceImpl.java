package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public Page<User> findUserByPage(int currentPage, int pageSize, String name){

        Sort sort = Sort.by(Sort.Direction.DESC,"age");
        Pageable pageable=  PageRequest.of(currentPage-1,pageSize,sort);
        return userDao.findByNameLike(name,pageable);
    }
}
