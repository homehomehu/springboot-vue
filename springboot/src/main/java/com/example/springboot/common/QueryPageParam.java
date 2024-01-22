package com.example.springboot.common;

import lombok.Data;

import java.util.HashMap;

// 对请求入参的封装
@Data
public class QueryPageParam {
    // 默认的静态数据
    private static int PAGE_SIZE=2; //一页展示几条数据
    private static int PAGE_NUM=1; //页码

    private int pageSize=PAGE_SIZE;
    private int pageNum=PAGE_NUM;

    private HashMap param;  //HashMap是一种存储键值对的数据结构
}
