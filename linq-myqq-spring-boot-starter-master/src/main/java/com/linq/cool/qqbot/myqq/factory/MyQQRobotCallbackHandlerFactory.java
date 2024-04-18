package com.linq.cool.qqbot.myqq.factory;


import com.linq.cool.qqbot.myqq.annotation.MyQQRobotCommand;
import com.linq.cool.qqbot.myqq.enums.InternalUtilEnum;
import com.linq.cool.qqbot.myqq.exception.UtilException;
import com.linq.cool.qqbot.myqq.handler.MyQQRobotCommandHandler;
import com.linq.cool.qqbot.myqq.callback.MyQQMessageCallbackRequest;
import com.linq.cool.qqbot.myqq.response.MyQQMessageCallbackResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yqlin
 * @date 2021/8/5 20:15
 * @description MyQQ机器指令策略工厂类
 * 为constructor（构造方法）——>@Autowired——>@postConstruct -->实现InitializingBean中的afterPropertiesSet()方法
 * @bug 容易出现bug, 注意这里@Autowired的生命周期
 */
@Slf4j
@Component
public class MyQQRobotCallbackHandlerFactory {
    private Map<MyQQRobotCommand, MyQQRobotCommandHandler> map;
    private String commands;

    @Autowired
    public void setMap(List<MyQQRobotCommandHandler> handlers) {
        StringBuffer sbf = new StringBuffer();
        if (CollectionUtils.isEmpty(handlers)) {
            throw new UtilException(InternalUtilEnum.MY_QQ_ROBOT_CALLBACK_SERVICE_FACTORY__SET_MYQQ_COMMAND_MAP_ERROR);
        }
        this.map = handlers.stream().collect(Collectors.toMap(h -> AnnotationUtils.findAnnotation(h.getClass(), MyQQRobotCommand.class), v -> v, (v1, v2) -> v1));
        handlers.forEach(h -> sbf.append("(").append(Objects.requireNonNull(AnnotationUtils.findAnnotation(h.getClass(), MyQQRobotCommand.class)).regex()).append(")").append("|"));
        this.commands = sbf.substring(0, sbf.length() - 1);
    }

    public MyQQMessageCallbackResponse create(MyQQMessageCallbackRequest callbackRequest) {
        String message = callbackRequest.getMsg();
        log.info("指令接收信息: {}", message);
        log.info("全部机器指令: {}", commands);
        if (!message.matches(commands)) {
            return MyQQMessageCallbackResponse.intercept();
        }
        for (MyQQRobotCommand command : map.keySet()) {
            if (message.matches(command.regex())) {
                return map.get(command).handle(callbackRequest);
            }
        }
        throw new UtilException(InternalUtilEnum.MY_QQ_ROBOT_CALLBACK_SERVICE_FACTORY__CRATE_ERROR);
    }

    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer();
        List<String> list = new ArrayList<>();
        list.add("^dd\\(.*\\)$");
        list.add("^dd\\(.*\\)\\[@[1-9][0-9]{4,14}]$");
        list.add("\\[@[1-9][0-9]{4,14}]");
        list.forEach(h -> {
            sbf.append("(").append(h).append(")").append("|");
        });
        System.out.println(sbf.substring(0, sbf.length() - 1));
    }
}
