package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.User;

import java.util.List;

// IService<User>：表示这是针对实体类 User 的接口
public interface UserService extends IService<User> {
    List<User> listAll();
}
