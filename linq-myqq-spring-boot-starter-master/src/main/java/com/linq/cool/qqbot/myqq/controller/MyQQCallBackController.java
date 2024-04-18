package com.linq.cool.qqbot.myqq.controller;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.linq.cool.qqbot.myqq.callback.MyQQMessageCallbackRequest;
import com.linq.cool.qqbot.myqq.factory.MyQQRobotCallbackHandlerFactory;
import com.linq.cool.qqbot.myqq.response.MyQQMessageCallbackResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: yqlin
 * @date: 2021/7/4 11:59
 * @description: 回调接口
 */
@Slf4j
@RestController
@RequestMapping("/callback")
@RequiredArgsConstructor
public class MyQQCallBackController {
    private final MyQQRobotCallbackHandlerFactory myQQRobotCallbackServiceFactory;
    private final ThreadPoolExecutor executorService = new ThreadPoolExecutor(50, 50, 20L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1), new ThreadFactoryBuilder().setDaemon(true).setNameFormat("listen-qq-callback-pool-thread-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 机器人: 如 3377894260 2303574989 2719190494
     */
    @PostMapping("/listen/qq")
    public MyQQMessageCallbackResponse listen(@RequestBody MyQQMessageCallbackRequest callbackRequest) {
        Future<MyQQMessageCallbackResponse> future = executorService.submit(() -> {
            callbackRequest.setMsg(URLDecoder.decode(callbackRequest.getMsg(), "utf-8"));
            return myQQRobotCallbackServiceFactory.create(callbackRequest.setMsg(callbackRequest.getMsg().trim()));
        });
        try {
            return future.get();
        } catch (Exception ex) {
            log.error("MyQQ回调异常:{}", ex.getMessage(), ex);
        }
        return MyQQMessageCallbackResponse.intercept();
    }
}
