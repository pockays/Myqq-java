package com.linq.cool.qqbot.myqq.exception;


import com.linq.cool.qqbot.myqq.enums.InternalUtilEnum;

/**
 * @author: yqlin
 * @date: 2021/7/2 18:13
 * @description:
 */
public class UtilException extends RuntimeException {
    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilException(InternalUtilEnum interUtilEnum) {
        super(interUtilEnum.getMessage());
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
