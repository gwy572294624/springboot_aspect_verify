package com.aspect.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author
 * @Date 2020/12/30 下午2:45
 * @Version 1.0
 * @Remarks
 */
@Aspect
@Component
@Slf4j
public class TokenAspect {

    @Pointcut("@annotation(com.aspect.config.TokenVerify)")
    public void tokenAspect() {

    }

    @Around("tokenAspect()")
    public Object beforePointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("  切面类  ---！");
        try{
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            TokenVerify tokenVerify = signature.getMethod().getDeclaredAnnotation(TokenVerify.class);
            String value = tokenVerify.value();
            System.out.println("==注解@TokenVerify的value==" + value);
            //获取RequestAttributes
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            //从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            String data = request.getHeader("Authorization");
            if (ObjectUtils.isEmpty(data)){
                return JSON.toJSONString("token - null");
            }
            //业务逻辑通过token查询验证
            //-------



            //验证完成后调用触发aop前置的方法 并返回处理完成的结果
            Object result = joinPoint.proceed();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("签名不合法");
        }
    }



}
