package com.linq.cool.qqbot.myqq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yqlin
 * @date 2021/8/5 21:14
 * @description 内部工具枚举
 */
@AllArgsConstructor
@Getter
public enum InternalUtilEnum {
    /**
     * 工具类异常
     */
    MY_QQ_ROBOT_CALLBACK_SERVICE_FACTORY__CRATE_ERROR(999, "MyQQRobotCallbackServiceFactory.create异常,解析信息空指针异常"),
    MY_QQ_ROBOT_CALLBACK_SERVICE_FACTORY__SET_MYQQ_COMMAND_MAP_ERROR(999, "MyQQRobotCallbackServiceFactory.setMyQQCommandMap异常,注解regex空指针异常"),
    MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__TYPE_NOT_MATCH_ERROR(999, "MyQQHttpRequestTemplate.doRequest,参数类型不匹配异常"),
    MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__LACK_OF_ANNOTATION_REQUEST_ENTITY_ERROR(999, "MyQQHttpRequestTemplate.doRequest,缺少注解@RequestEntity异常"),
    MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__LACK_OF_ANNOTATION_REQUEST_ARG_ERROR(999, "MyQQHttpRequestTemplate.doRequest,该类某属性缺少@RequestArg异常"),
    MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__LACK_OF_ANNOTATION_REQUEST_ARG_NOT_SATISFY_C_ARGS_ERROR(999, "MyQQHttpRequestTemplate.doRequest,该类某属性@RequestArg的key不满足c1,c2...ci,i>=1异常");
    int code;
    String message;
}
