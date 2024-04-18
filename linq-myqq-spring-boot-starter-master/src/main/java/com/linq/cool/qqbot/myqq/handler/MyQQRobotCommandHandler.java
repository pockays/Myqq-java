package com.linq.cool.qqbot.myqq.handler;


import com.linq.cool.qqbot.myqq.callback.MyQQMessageCallbackRequest;
import com.linq.cool.qqbot.myqq.response.MyQQMessageCallbackResponse;

/**
 * @author yqlin
 * @date 2021/8/6 9:54
 * @description
 */
public interface MyQQRobotCommandHandler {
    /**
     * 处理回调信息
     *
     * @param callbackRequest 回调信息
     *
     * @return 回调请求结果
     */
    MyQQMessageCallbackResponse handle(MyQQMessageCallbackRequest callbackRequest);
}
