package com.linq.cool.qqbot.myqq.request.myqq;

import com.linq.cool.qqbot.myqq.annotation.RequestArg;
import com.linq.cool.qqbot.myqq.annotation.RequestEntity;
import com.linq.cool.qqbot.myqq.enums.MyQQApiEnum;
import com.linq.cool.qqbot.myqq.request.AbstractMyQQRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author liuris
 * @create 2024-04-18-20:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@RequestEntity(apiEnum = MyQQApiEnum.API_SEND_MSG)
public class MyQQApiSendMsgRequest extends AbstractMyQQRequest {
    /**
     * 机器人QQ
     */
    @RequestArg(key = "c1")
    private String robotQQ;
    /**
     * 1好友 2群 3讨论组 4群临时会话 5讨论组临时会话 6在线临时会话
     */
    @RequestArg(key = "c2")
    private Integer infoType;
    /**
     * 发送群信息、讨论组信息、群临时会话信息、讨论组临时会话信息时填写
     */
    @RequestArg(key = "c3")
    private String group;
    /**
     * 最终接收这条信息的对象QQ
     */
    @RequestArg(key = "c4")
    private String targetQQ;
    /**
     * 信息内容
     */
    @RequestArg(key = "c5")
    private String content;
}
