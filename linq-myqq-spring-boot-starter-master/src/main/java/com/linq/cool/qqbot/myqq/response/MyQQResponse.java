package com.linq.cool.qqbot.myqq.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: yqlin
 * @date: 2021/7/2 9:16
 * @description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class MyQQResponse implements Serializable {
    /**
     * success	成功为true，失败为false
     * code	状态码，成功为200，其他为失败，需要注意的是，这里的只是HTTPAPI调用成功，并不代表函数调用成功
     * message	状态说明，成功为“成功”，失败为原因
     * data	接口返回的具体数据，需自行解析
     * data.ret	大部分接口的返回值在此处
     * 成功示例
     * <p>
     * {
     * "success": true,
     * "code": 200,
     * "message": "成功",
     * "data": {
     * "ret": "22d5f9bd9363a533b2678d9391504be1"
     * }
     * }
     * 失败示例
     * <p>
     * {
     * "success": false,
     * "code": 100,
     * "message": "token error",
     * "data": {}
     * }
     */
    @JSONField(name = "success")
    private Boolean success;
    @JSONField(name = "code")
    private Integer code;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "data")
    private Map<String, Object> data;
}
