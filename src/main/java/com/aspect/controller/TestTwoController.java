package com.aspect.controller;

import com.aspect.config.TokenVerify;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2021/1/8 下午4:57
 * @Version 1.0
 * @Remarks  @TokenVerify 直接标注在类上，下面的方法并不会触发aop逻辑
 */
@RestController
@TokenVerify("我在类上")
@RequestMapping(value ="/testtwo/aop/verify")
public class TestTwoController {


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
