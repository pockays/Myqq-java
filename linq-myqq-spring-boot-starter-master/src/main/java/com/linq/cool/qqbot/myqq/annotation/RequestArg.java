package com.linq.cool.qqbot.myqq.annotation;

import java.lang.annotation.*;

/**
 * @author yqlin
 * @date 2021/7/2 18:00
 * @description 标注MyQQ请求参数key
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestArg {
    String key();
}
