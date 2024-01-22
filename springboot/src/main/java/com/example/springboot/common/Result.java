package com.example.springboot.common;

import lombok.Data;

@Data
// 后端返回给前端的结果封装，方便处理
public class Result {
    private int code;
    private String msg;
    private Long total; // 总记录数
    private Object data;  // 有可能是数组，有可能是对象，类型不确定所以用Object

    // 构造方法
    private static Result result(int code, String msg, Long total, Object data){
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);

        return res;
    }

    public static Result fail(){
        return result(400, "失败", 0L, null);
    }

    public static Result suc(){
        return result(200, "成功", 0L, null);
    }

    // 带数据的成功
    public static Result suc(Object data){
        return result(200, "成功", 0L, data);
    }

    public static Result suc(Object data, Long total){
        return result(200, "成功", total, data);
    }
}