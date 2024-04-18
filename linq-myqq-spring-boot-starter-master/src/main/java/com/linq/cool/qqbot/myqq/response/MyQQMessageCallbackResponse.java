package com.linq.cool.qqbot.myqq.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yqlin
 * @date: 2021/7/4 12:02
 * @description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class MyQQMessageCallbackResponse {
    /**
     * 1=其他插件可继续处理此条消息，2=拦截信息，此条消息不再分发给其他插件，其他插件将不能再处理
     */
    @JsonProperty("status")
    private Integer status;

    public static MyQQMessageCallbackResponse next() {
        return new MyQQMessageCallbackResponse(1);
    }

    public static MyQQMessageCallbackResponse intercept() {
        return new MyQQMessageCallbackResponse(2);
    }
}
