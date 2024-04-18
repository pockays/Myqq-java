package com.linq.cool.qqbot.myqq.annotation;


import com.linq.cool.qqbot.myqq.enums.MyQQApiEnum;

import java.lang.annotation.*;

/**
 * @author yqlin
 * @date 2021/7/2 18:19
 * @description 标注是MyQQ请求实体
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestEntity {
    MyQQApiEnum apiEnum();
}
