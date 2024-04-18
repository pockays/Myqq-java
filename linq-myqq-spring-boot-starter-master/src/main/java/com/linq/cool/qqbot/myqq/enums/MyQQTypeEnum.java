package com.linq.cool.qqbot.myqq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: yqlin
 * @date: 2021/7/1 9:06
 * @description: MyQQ常量枚举
 */
@AllArgsConstructor
@Getter
public enum MyQQTypeEnum {
    /**
     * 消息类型
     */
    MESSAGE_TYPE_UNDEFINED(-1, "消息类型_未定义"),
    MESSAGE_TYPE_FRIEND(1, "消息类型_好友"),
    MESSAGE_TYPE_GROUP(2, "消息类型_群"),
    MESSAGE_TYPE_DISCUSSION_GROUP(3, "消息类型_讨论组"),
    MESSAGE_TYPE_GROUP_TEMP_SESSION(4, "消息类型_群临时会话"),
    MESSAGE_TYPE_DISCUSSION_GROUP_TEMP_SESSION(5, "消息类型_讨论组临时会话"),
    MESSAGE_TYPE_ONLINE_TEMP_SESSION(6, "消息类型_在线临时会话"),
    MESSAGE_TYPE_BEING_ADDED_AS_FRIEND_IN_ONE_DIRECTION(1000, "消息类型_被单向添加好友"),
    MESSAGE_TYPE_REQUEST_TO_ADD_FRIEND(1001, "消息类型_被请求添加好友"),
    MESSAGE_TYPE_FRIEND_STATUS_CHANGE(1002, "消息类型_好友状态改变"),
    MESSAGE_TYPE_DELETED_FRIENDS(1003, "消息类型_被删除好友"),
    MESSAGE_TYPE_FRIEND_SIGNATURE_CHANGE(1004, "消息类型_好友签名变更"),
    MESSAGE_TYPE_TALK_ABOUT_BEING_COMMENTED(1005, "消息类型_说说被评论"),
    MESSAGE_TYPE_FRIENDS_ARE_TYPING(1006, "消息类型_好友正在输入"),
    MESSAGE_TYPE_FRIENDS_START_FIRST_SESSION(1007, "消息类型_好友今天首次发起会话"),
    MESSAGE_TYPE_JITCHED_BY_FRIENDS(1008, "消息类型_被好友抖动"),
    MESSAGE_TYPE_FRIEND_FILE_RECEIVING(1009, "消息类型_好友文件接收"),
    MESSAGE_TYPE_MESSAGE_TYPE_FRIEND_VIDEO_RECEIVING(1010, "消息类型_好友视频接收"),
    MESSAGE_TYPE_BE_INVITE_TO_GROUP(2001, "消息类型_某人申请加入群"),
    MESSAGE_TYPE_SOMEONE_APPLIED_TO_JOIN_GROUP(2002, "消息类型_某人被邀请加入群"),
    MESSAGE_TYPE_SOMEONE_HAS_BEEN_INVITED_INTO_GROUP(20021, "消息类型_某人已被邀请入群"),
    MESSAGE_TYPE_I_WAS_INVITED_INTO_GROUP(2003, "消息类型_我被邀请加入群"),
    MESSAGE_TYPE_SOMEONE_WAS_ADMITTED_TO_GROUP(2005, "消息类型_某人被批准加入了群"),
    MESSAGE_TYPE_SOMEONE_DROP_OUT_OF_GROUP(2006, "消息类型_某人退出群"),
    MESSAGE_TYPE_SOMEONE_IS_MANAGED_TO_REMOVE_GROUP(2007, "消息类型_某人被管理移除群"),
    MESSAGE_TYPE_GROUP_IS_DISABLED(2008, "消息类型_某群被解散"),
    MESSAGE_TYPE_ONE_BECOME_MANAGER(2009, "消息类型_某人成为管理"),
    MESSAGE_TYPE_SOME_IS_TAKEN_OUT_OF_ADMIN(2010, "消息类型_某人被取消管理"),
    MESSAGE_TYPE_GROUP_CARD_CHANGE(2011, "消息类型_群名片变动"),
    MESSAGE_TYPE_GROUP_NICK_CHANGE(2012, "消息类型_群名变动"),
    MESSAGE_TYPE_GROUP_ANNOUNCEMENT_CHANGE(2013, "消息类型_群公告变动"),
    MESSAGE_TYPE_SUBJECT_IS_BANNED(2014, "消息类型_对象被禁言"),
    MESSAGE_TYPE_SUBJECT_IS_UNGAGGED(2015, "消息类型_对象被解除禁言"),
    MESSAGE_TYPE_GROUP_MANAGEMENT_TURNS_ON_THE_WHOLE_GROUP_GAG(2016, "消息类型_群管开启全群禁言"),
    MESSAGE_TYPE_GROUP_MANAGER_SHUTS_DOWN_THE_WHOLE_GROUP_GAG(2017, "消息类型_群管关闭全群禁言"),
    MESSAGE_TYPE_GROUP_MANAGER_STARTS_ANONYMOUS_CHAT(2018, "消息类型_群管开启匿名聊天"),
    MESSAGE_TYPE_GROUP_MANAGER_TURNS_OFF_ANONYMOUS_CHAT(2019, "消息类型_群管关闭匿名聊天"),
    MESSAGE_TYPE_GROUP_RECALL_MESSAGE(2020, "消息类型_群撤回消息"),
    MESSAGE_TYPE_GROUP_FILE_RECEPTION(2021, "消息类型_群文件接收"),
    MESSAGE_TYPE_GROUP_VIDEO_RECEPTION(2022, "消息类型_群视频接收"),
    MESSAGE_TYPE_FRIEND_VOICE_RECEPTION(3001, "消息类型_好友语音接收"),
    MESSAGE_TYPE_GROUP_VOICE_RECEPTION(3002, "消息类型_群语音接收"),
    MESSAGE_TYPE_FRAMEWORK_IS_LOADED(10000, "消息类型_框架加载完成"),
    MESSAGE_TYPE_FRAMEWORK_WILL_BE_RESTARTED_SOON(10001, "消息类型_框架即将重启"),
    MESSAGE_TYPE_NEW_ACCOUNT_HAS_BEEN_ADDED(11000, "消息类型_添加了一个新的帐号"),
    MESSAGE_TYPE_QQ_LOGIN_COMPLETED(11001, "消息类型_QQ登录完成"),
    MESSAGE_TYPE_QQ_WAS_TAKEN_OFFLINE_MANUALLY(11002, "消息类型_QQ被手动离线"),
    MESSAGE_TYPE_QQ_WAS_FORCED_OFFLINE(11003, "消息类型_QQ被强制离线"),
    MESSAGE_TYPE_QQ_FOR_LONE_TIME_NO_RESPONSE_OR_DROPPED_LINE(11004, "消息类型_QQ长时间无响应或掉线"),
    MESSAGE_TYPE_THE_PLUGIN_LOADS(12000, "消息类型_本插件载入"),
    MESSAGE_TYPE_PLUGIN_IS_ENABLED(12001, "消息类型_插件被启用"),
    MESSAGE_TYPE_PLUGIN_IS_DISABLED(12002, "消息类型_插件被禁用"),
    MESSAGE_TYPE_PLUGIN_IS_CLICKED(12003, "消息类型_插件被点击"),
    MESSAGE_TYPE_TENPAY_TANSFER_RECEIVED(80001, "消息类型_收到财付通转账"),
    MESSAGE_TYPE_RECEIVE_A_GROUP_CHAT_RED_ENVELOPE(80002, "消息类型_收到群聊红包"),
    MESSAGE_TYPE_RECEIVE_A_PRIVATE_RED_ENVELOPE(80003, "消息类型_收到私聊红包"),
    MESSAGE_TYPE_ROBOT_SEND_A_MESSAGE(80004, "消息类型_机器人发出消息"),
    /**
     * 事件处理
     */
    EVENT_HANDLE_IGNORE(0, "事件处理_忽略"),
    EVENT_HANDLE_AGREE(10, "事件处理_同意"),
    EVENT_HANDLE_REFUSE(20, "事件处理_拒绝"),
    /**
     * 消息处理
     */
    MESSAGE_HANDLE_IGNORED(0, "消息处理_忽略"),
    MESSAGE_HANDLE_CONTINUE(1, "消息处理_继续"),
    MESSAGE_HANDLE_INTERCEPT(2, "消息处理_拦截"),
    /**
     * QQ状态
     */
    QQ_STATUS_ONLINE(10, "状态_在线"),
    QQ_STATUS_LEAVE(30, "状态_离开"),
    QQ_STATUS_BUSY(50, "状态_忙碌"),
    QQ_STATUS_QME(60, "状态_Q我吧"),
    QQ_STATUS_NOT_DISTURB(70, "状态_勿扰"),
    QQ_STATUS_INVISIBLE(40, "状态_隐身"),
    SYSTEM_TYPE_OTHERS(-9999, "暂无");

    private final Integer code;
    private final String description;

    public static MyQQTypeEnum getByCode(Integer code) {
        for (MyQQTypeEnum transactType : values()) {
            if (transactType.getCode().equals(code)) {
                return transactType;
            }
        }
        return SYSTEM_TYPE_OTHERS;
    }
}
