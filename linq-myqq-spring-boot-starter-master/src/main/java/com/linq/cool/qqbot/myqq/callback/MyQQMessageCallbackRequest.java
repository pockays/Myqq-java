package com.linq.cool.qqbot.myqq.callback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yqlin
 * @date: 2021/7/4 12:02
 * @description:
 */
@Data
@Accessors(chain = true)
public class MyQQMessageCallbackRequest {
    /**
     * MQ_robot	用于判定哪个QQ接收到该消息
     * MQ_type	接收到消息类型，该类型可在[常量列表]中查询具体定义
     * MQ_type_sub	此参数在不同情况下，有不同的定义
     * MQ_fromID	此消息的来源，如：群号、讨论组ID、临时会话QQ、好友QQ等
     * MQ_fromQQ	主动发送这条消息的QQ，踢人时为踢人管理员QQ
     * MQ_passiveQQ	被动触发的QQ，如某人被踢出群，则此参数为被踢出人QQ
     * MQ_msg	（此参数将被URL UTF8编码，您收到后需要解码处理）此参数有多重含义，常见为：对方发送的消息内容，但当消息类型为 某人申请入群，则为入群申请理由,当消息类型为财付通转账时为原始json
     * MQ_msgSeq	此参数暂定用于消息撤回
     * MQ_msgID	此参数暂定用于消息撤回
     * MQ_msgData	UDP收到的原始信息，特殊情况下会返回JSON结构（入群事件时，这里为该事件data）
     * {
     * "MQ_robot": "1330166568",
     * "MQ_type": 1,
     * "MQ_type_sub": 0,
     * "MQ_fromID": "1330166565",
     * "MQ_fromQQ": "1330166565",
     * "MQ_passiveQQ": "1330166568",
     * "MQ_msg": "123%E6%B5%8B%E8%AF%95",
     * "MQ_msgSeq": "1482636593",
     * "MQ_msgID": "1243",
     * "MQ_msgData": "4F 48 BB 25 4F 48 BB 28 00 06 36 04 09 95 68 BD 1F 40 00 A6 00 00 00 2D 00 05 00 02 00 01 00 06 00 04 00 01 01 01 00 09 00 06 00 01 00 00 00 01 00 0A 00 04 01 00 00 00 00 01 00 04 00 00 00 00 00 03 00 01 02 3A 03 4F 48 BB 25 4F 48 BB 28 E7 B9 55 10 DA 5A 21 52 F4 EA 9C 41 C7 BE F7 A8 00 0B 04 DB 60 75 66 A5 02 43 00 00 00 00 01 00 00 00 01 4D 53 47 00 00 00 00 00 60 75 66 A5 58 5F 3D 31 00 00 00 00 0B 00 86 31 00 0C E5 BE AE E8 BD AF E9 9B 85 E9 BB 91 00 00 01 00 0C 01 00 09 31 32 33 E6 B5 8B E8 AF 95 19 00 1E 01 00 1B AA 02 18 08 08 9A 01 13 78 80 80 04 C8 01 00 F0 01 00 F8 01 00 90 02 00 CA 04 00 0E 00 07 01 00 04 00 00 00 00"
     * }
     */
    /**
     * 用于判定哪个QQ接收到该消息
     */
    @JsonProperty("MQ_robot")
    private String robotQQ;
    /**
     * 接收到消息类型，该类型可在[常量列表]中查询具体定义
     */
    @JsonProperty("MQ_type")
    private Integer type;
    /**
     * 此参数在不同情况下，有不同的定义
     */
    @JsonProperty("MQ_type_sub")
    private Integer subType;
    /**
     * 此消息的来源，如：群号、讨论组ID、临时会话QQ、好友QQ等
     */
    @JsonProperty("MQ_fromID")
    private String fromId;
    /**
     * 主动发送这条消息的QQ，踢人时为踢人管理员QQ
     */
    @JsonProperty("MQ_fromQQ")
    private String fromQQ;
    /**
     * 被动触发的QQ，如某人被踢出群，则此参数为被踢出人QQ
     */
    @JsonProperty("MQ_passiveQQ")
    private String passiveQQ;
    /**
     * （此参数将被URL UTF8编码，您收到后需要解码处理）此参数有多重含义，常见为：对方发送的消息内容，但当消息类型为 某人申请入群，则为入群申请理由,当消息类型为财付通转账时为原始json
     */
    @JsonProperty("MQ_msg")
    private String msg;
    /**
     * 此参数暂定用于消息撤回
     */
    @JsonProperty("MQ_msgSeq")
    private String msgSeq;
    /**
     * 此参数暂定用于消息撤回
     */
    @JsonProperty("MQ_msgID")
    private String msgId;
    /**
     * UDP收到的原始信息，特殊情况下会返回JSON结构（入群事件时，这里为该事件data）
     */
    @JsonProperty("MQ_msgData")
    private String msgData;
}
