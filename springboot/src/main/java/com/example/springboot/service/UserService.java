package com.example.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiajiajia
 * @since 2023-12-14
 */
public interface UserService extends IService<User> { // Iservice就来自于mybatis-plus
    IPage pageC(IPage<User> page);  //IPage<User>：IPage 是 MyBatis-Plus 中用于表示分页查询结果的接口,User 是表示查询结果的实体对象类型
}
