package com.linq.cool.qqbot.myqq.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: yqlin
 * @date: 2021/7/2 14:55
 * @description: MyQQ请求体封装dto
 */
@Data
@Accessors(chain = true)
public class MyQQRequest implements Serializable {
    @JSONField(name = "function")
    private String function;
    @JSONField(name = "token")
    private String token;
    @JSONField(name = "params")
    private Map<String, Object> params;
}
