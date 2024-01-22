package com.example.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.QueryPageParam;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiajiajia
 * @since 2023-12-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list") // @GetMapping 注释处理前端的 Get 请求，并将 return 的结果返回给前端
    public List<User> list(){
        return userService.list();
    }

    // 新“增”用户
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return  userService.save(user);
    }

    // 修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return  userService.updateById(user);
    }

    // 新增或修改（如果id不存在就新增，存在就修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return  userService.saveOrUpdate(user);
    }

    // 删除
    @GetMapping("/delete")
    public boolean save(Integer id){
        return  userService.removeById(id);
    }

    /**模糊查询
     *例如：匹配name为胡家家的用户）
     */
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(!StringUtils.isEmpty(user.getName())){
            lambdaQueryWrapper.like(User::getName,user.getName()); //SELECT * FROM user_table WHERE name LIKE ''
        }
        return userService.list(lambdaQueryWrapper);  //这个list和前面那个不一样，里面要放QueryWrapper参数的
    }

    // 分页之前，封装参数。首先为了封装参数写了个QueryPageParam（里面是对请求发来的参数的一些封装）
    // 这个方法只是测试一下参数有没有被封装好
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query){
        System.out.println(query);

        System.out.println("pageNum=="+query.getPageNum());
        System.out.println("pageSize=="+query.getPageSize());
        System.out.println("param.stu_no=="+query.getParam().get("stu_no"));  //param的数据结构是HashMap，PageNum和PageSize以外的参数都被封装在Param里面，前端可以从Param里面传递

        return null;
    }

    @PostMapping("/listPage2")
    public List<User> listPage2(@RequestBody QueryPageParam query){
        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());  // 设置当前页
        page.setSize(query.getPageSize());  //设置每页的结果数

        HashMap param = query.getParam();
        String name = (String) param.get("name"); // (String)是强制性类型转换
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName,name);

        IPage result = userService.page(page,lambdaQueryWrapper); // 返回的就是一个Ipage对象，与IPage不同，Page类只表示分页信息，而不包含查询结果

        System.out.println("total=="+result.getTotal());

        return result.getRecords(); // 从分页结果对象中获取**当前页**的数据记录
    }

    // 自定义sql语句+分页【分页的Mapper方法】
    @PostMapping("/listPage3")
    public List<User> listPage3(@RequestBody QueryPageParam query){
        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());  // 设置当前页
        page.setSize(query.getPageSize());  //设置每页的结果数

        IPage result = userService.pageC(page); //和前面/listPage2不同，这里是自定义的方法

        System.out.println("total=="+result.getTotal());

        return result.getRecords(); // result是一个IPage数据类型（针对分页用的），result.getRecords()得到的是当前分页的记录列表
    }

    // 对后端数据进行处理
    @PostMapping("/BackendProcess")
    public Result BackendProcess(@RequestBody QueryPageParam query){
        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());  // 设置当前页
        page.setSize(query.getPageSize());  //设置每页的结果数

        IPage result = userService.pageC(page); //和前面/listPage2不同，这里是自定义的方法
                                                // pageC的功能是 select * from user，括号里面是page的话就是展示当前页

        return Result.suc(result.getRecords(), result.getTotal()); // Result类里面的suc()是静态方法，静态方法在类级别上操作，而不依赖于特定的实例。
    }
}
