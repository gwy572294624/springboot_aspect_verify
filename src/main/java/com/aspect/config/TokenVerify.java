package com.aspect.config;

import java.lang.annotation.*;

/**
 * @Author
 * @Date 2020/12/30 下午2:43
 * @Version 1.0
 * @Remarks
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenVerify {

    String value() default "";

}
