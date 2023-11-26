package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// 该注解说明此**类的所有方法**的返回值都直接作为 http 请求的 body 部分返回
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping
    // 该注解表明是处理 GET 请求的
    public String hello() {
        return "hello my name is GG~";
    }

    @GetMapping("/list")
    // List<User>是一个“泛型”类型，其中在尖括号里面使用数据类型
    public List<User> list() {
        return userService.list(); // 这里可以直接 .list() 其实是 mybatis plus 的功劳
    }

    @GetMapping("/list2")
    public List<User> listAll() {
        return userService.listAll(); // 试着自己来实现一个方法
    }
}
