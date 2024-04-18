package com.linq.cool.qqbot.myqq.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author yqlin
 * @date 2021/8/6 9:46
 * @description 机器指令注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyQQRobotCommand {
    /**
     * 正则表达式
     *
     * @return {@link String}
     */
    String regex();
}
