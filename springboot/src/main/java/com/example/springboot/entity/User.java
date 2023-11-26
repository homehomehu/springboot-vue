package com.example.springboot.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String no;
    private String name;
    private String password;
    private int sex;
    private int roleId; // 因为原本在数据库里的字段就是role_id，所以这里可以直接大写
    private String phone;
    private String isvalid; // 原本在数据库里面的字段是isValid,如果这里我们写成isValid，会被认为在数据库里的是is_valid，所以会报错！
}
