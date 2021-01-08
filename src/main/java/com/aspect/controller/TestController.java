package com.aspect.controller;

import com.aspect.config.TokenVerify;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2021/1/8 下午4:45
 * @Version 1.0
 * @Remarks
 */
@RestController
@RequestMapping(value ="/test/aop/verify")
public class TestController {



    @TokenVerify("我在methodOne上")
    @RequestMapping("/methodOne")
    public String methodOne(){
        System.out.println("新增用户  ----- ");
        return "新增成功";
    }

    @RequestMapping("/methodTwo")
    public String methodTwo(){
        System.out.println("删除用户  ----- ");
        return "删除成功";
    }
}
