package com.linq.cool.qqbot.myqq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpMethod;

/**
 * @author: yqlin
 * @date: 2021/7/1 13:06
 * @description: API枚举 官网请求方式没有请求体的GET,POST都可以所以全部POST
 */
@AllArgsConstructor
@Getter
public enum MyQQApiEnum {
    /**
     * Api_GetVer	文本型	取框架版本号
     */
    API_GET_VER("Api_GetVer", String.class, HttpMethod.POST),
    /**
     * Api_GetTimeStamp	整数型	取当前框架内部时间戳
     */
    API_GET_TIME_STAMP("Api_GetTimeStamp", Integer.class, HttpMethod.POST),
    /**
     * Api_IsEnable	布尔型	取得插件自身启用状态，启用真 禁用假
     */
    API_IS_ENABLE("Api_IsEnable", Boolean.class, HttpMethod.POST),
    /**
     * Api_DisabledPlugin	无返回值	请求禁用插件自身
     */
    API_DISABLED_PLUGIN("Api_DisabledPlugin", Void.class, HttpMethod.POST),
    /**
     * Api_OutPut	无返回值	在框架记录页输出一行信息
     * 内容	文本型	输出的内容
     */
    API_OUT_PUT("Api_OutPut", Void.class, HttpMethod.POST),
    /**
     * Api_GetNick	文本型	取用户名
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	欲取得的QQ的号码
     */
    API_GET_NICK("Api_GetNick", String.class, HttpMethod.POST),
    /**
     * Api_SendMsg	无返回值	向对象、目标发送信息 支持好友 群 讨论组 群临时会话 讨论组临时会话
     * 响应QQ	文本型	机器人QQ
     * 信息类型	整数型	1好友 2群 3讨论组 4群临时会话 5讨论组临时会话 6在线临时会话
     * 收信群_讨论组	文本型	发送群信息、讨论组信息、群临时会话信息、讨论组临时会话信息时填写
     * 收信对象	文本型	最终接收这条信息的对象QQ
     * 内容	文本型	信息内容
     */
    API_SEND_MSG("Api_SendMsg", Void.class, HttpMethod.POST),
    /**
     * Api_SendMsgEx	无返回值	向对象、目标发送信息 支持好友 群 讨论组 群临时会话 讨论组临时会话
     * 响应QQ	文本型	机器人QQ
     * 匿名	整数型	0为普通 1为匿名（匿名需要群开启）
     * 信息类型	整数型	1好友 2群 3讨论组 4群临时会话 5讨论组临时会话 6在线临时会话
     * 收信群_讨论组	文本型	发送群信息、讨论组信息、群临时会话信息、讨论组临时会话信息时填写
     * 收信对象	文本型	最终接收这条信息的对象QQ
     * 内容	文本型	信息内容
     * 气泡ID	整数型	（已失效）默认为0使用本来的气泡，-1为随机气泡
     */
    API_SEND_MSG_EX("Api_SendMsgEx", Void.class, HttpMethod.POST),
    /**
     * Api_SendLongMsg	无返回值	使用HTTP模式发信，可用于发送长消息
     * 响应QQ	文本型	机器人QQ
     * 匿名	整数型	0为普通 1为匿名（匿名需要群开启）
     * 信息类型	整数型	1好友 2群
     * 收信群号	文本型	信息类型=2时填写群号，信息类型=1时留空
     * 收信对象	文本型	信息类型=1时填写收信对象QQ，信息类型=2时留空
     * 内容	文本型	信息内容
     * 匿名	整数型	0为普通，1为匿名
     */
    API_SEND_LONG_MSG("Api_SendLongMsg", Void.class, HttpMethod.POST),
    /**
     * 响应QQ	文本型	机器人QQ
     * 匿名	整数型	0为普通 1为匿名（匿名需要群开启）
     * 信息类型	整数型	同Api_SendMsg 1好友 2群 3讨论组 4群临时会话 5讨论组临时会话
     * 收信群_讨论组	文本型	发群内、临时会话必填 好友可不填
     * 收信对象	文本型	临时会话、好友必填 发至群内可不填
     * ObjectMsg	文本型	XML代码
     * 结构子类型	整数型	00 基本 02 点歌 其他不明
     */
    API_SEND_XML("Api_SendXml", String.class, HttpMethod.POST),
    /**
     * Api_SendJson	无返回值	发送JSON结构消息
     * 响应QQ	文本型	机器人QQ
     * 匿名	整数型	（暂不支持）0为普通 1为匿名（匿名需要群开启）
     * 信息类型	整数型	同Api_SendMsg 1好友 2群 3讨论组 4群临时会话 5讨论组临时会话
     * 收信群_讨论组	文本型	发群内、临时会话必填 好友可不填
     * 收信对象	文本型	临时会话、好友必填 发至群内可不填
     * Json结构	文本型	Json结构内容
     */
    API_SEND_JSON("Api_SendJson", Void.class, HttpMethod.POST),
    /**
     * Api_GetFriendList	文本型	取得好友列表，返回获取到的原始JSON格式信息，需自行解析
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_FRIEND_LIST("Api_GetFriendList", String.class, HttpMethod.POST),
    /**
     * Api_GetFriendList_B	文本型	取得好友列表，返回内容#换行符分割
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_FRIEND_LIST_B("Api_GetFriendList_B", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupList	文本型	取得群列表，返回获取到的原始JSON格式信息，需自行解析
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_GROUP_LIST("Api_GetGroupList", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupList_A	文本型	取得群列表，#换行符分割 不受最高获取500群限制（如需获取群名称请对应调用 Api_GetGroupName 理论群名获取不会频繁）
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_GROUP_LIST_A("Api_GetGroupList_A", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupList_B	文本型	取得群列表，返回获取到的原始JSON格式信息，需自行解析
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_GROUP_LIST_B("Api_GetGroupList_B", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupMemberList	文本型
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲取群成员列表群号
     */
    API_GET_GROUP_MEMBER_LIST("Api_GetGroupMemberList", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupMemberList_B	文本型	取得群成员列表，#换行符分割 失败返回空（无群员昵称）
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	无
     */
    API_GET_GROUP_MEMBER_LIST_B("Api_GetGroupMemberList_B", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupMemberList_C	文本型	取得群成员列表，返回获取到的原始JSON格式信息，需自行解析（有群员昵称）
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲取群成员列表群号
     */
    API_GET_GROUP_MEMBER_LIST_C("Api_GetGroupMemberList_C", String.class, HttpMethod.POST),
    /**
     * Api_GetAdminList	文本型	取包括群主在内的群管列表，#换行符分割
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲取管理员列表群号
     */
    API_GET_ADMIN_LIST("Api_GetAdminList", String.class, HttpMethod.POST),
    /**
     * Api_GetCookies	文本型	取得机器人网页操作用的Cookies
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_COOKIES("Api_GetCookies", String.class, HttpMethod.POST),
    /**
     * Api_GetBlogPsKey	文本型	取得腾讯微博页面操作用参数P_skey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_BLOG_PS_KEY("Api_GetBlogPsKey", String.class, HttpMethod.POST),
    /**
     * Api_GetZonePsKey	文本型	取得QQ空间页面操作用参数P_skey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_ZONE_PS_KEY("Api_GetZonePsKey", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupPsKey	文本型	取得QQ群页面操作用参数P_skey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_GROUP_PS_KEY("Api_GetGroupPsKey", String.class, HttpMethod.POST),
    /**
     * Api_GetClassRoomPsKey	文本型	取得腾讯课堂页面操作用参数P_skey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_CLASS_ROOM_PS_KEY("Api_GetClassRoomPsKey", String.class, HttpMethod.POST),
    /**
     * Api_GetTenPayPsKey	文本型	取得财付通页面操作用参数P_skey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_TEN_PAY_PS_KEY("Api_GetTenPayPsKey", String.class, HttpMethod.POST),
    /**
     * Api_GetJuBaoPsKey	文本型	取得QQ举报页面操作用参数P_skey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_JUBAO_PS_KEY("Api_GetJuBaoPsKey", String.class, HttpMethod.POST),
    /**
     * Api_GetBkn	文本型	取得机器人网页操作用参数Bkn或G_tk
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_BKN("Api_GetBkn", String.class, HttpMethod.POST),
    /**
     * Api_GetBkn32	文本型	取得机器人网页操作用参数长Bkn或长G_tk
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_BKN_32("Api_GetBkn32", String.class, HttpMethod.POST),
    /**
     * Api_GetLongLdw	文本型	取得机器人网页操作用参数长Ldw
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_LONG_LDW("Api_GetLongLdw", String.class, HttpMethod.POST),
    /**
     * Api_GetClientkey	文本型	取得机器人网页操作用的Clientkey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_CLIENT_KEY("Api_GetClientkey", String.class, HttpMethod.POST),
    /**
     * Api_GetLongClientkey	文本型	取得机器人网页操作用的长Clientkey
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_LONG_CLIENT_KEY("Api_GetLongClientkey", String.class, HttpMethod.POST),
    /**
     * Api_SessionKey	文本型	获取会话SessionKey密钥
     * 响应QQ	文本型	机器人QQ
     */
    API_SESSION_KEY("Api_SessionKey", String.class, HttpMethod.POST),
    /**
     * Api_SetStatus	无返回值	设置机器人在线状态+附加信息
     * 响应QQ	文本型	机器人QQ
     * 在线状态	整数型	无
     * 状态附加信息	文本型	最大255字节
     */
    API_SET_STATUS("Api_SetStatus", Void.class, HttpMethod.POST),
    /**
     * 获取机器人状态信息，成功返回：昵称|帐号|在线状态|速度|收信|发信|在线时间，失败返回空
     * 响应QQString	机器人QQ
     */
    API_GET_STATUS("Api_GetStatus", String.class, HttpMethod.POST),


    /**
     * Api_GetNotice	文本型	取群公告列表，返回json
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲取得公告的群号
     */
    API_GET_NOTICE("Api_GetNotice", String.class, HttpMethod.POST),
    /**
     * Api_GetPicLink	文本型	根据图片GUID取得图片下载连接
     * 响应QQ	文本型	机器人QQ
     * 图片类型	整数型	1 群 讨论组 2临时会话和好友
     * 参考对象	文本型	图片所属对应的群号（可随意乱填写，只有群图片需要填写）
     * 图片GUID	文本型	例如[pic={xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx}.jpg]
     */
    API_GET_PICK_LINK("Api_GetPicLink", String.class, HttpMethod.POST),
    /**
     * Api_Like	文本型	调用一次点一下，成功返回空，失败返回理由如：每天最多给他点十个赞哦，调用此Api时应注意频率，每人每日可被赞10次，每日每Q最多可赞50人
     * 响应QQ	文本型	机器人QQ
     * 被赞QQ	文本型	填写被赞人QQ
     */
    API_GET_LIKE("Api_Like", String.class, HttpMethod.POST),
    /**
     * Api_UpLoadVoice	文本型	上传QQ语音，成功返回语音GUID 失败返回空
     * 响应QQ	文本型	机器人QQ
     * 语音文件	文本型	语音文件路径（AMR Silk编码）
     */
    API_UPLOAD_VOICE("Api_UpLoadVoice", String.class, HttpMethod.POST),
    /**
     * Api_UpLoadPic	文本型	上传图片，成功返回该图片GUID（格式为[pic={E9A12BBC-A5F9-1074-40D7-D1F229B4CA05}.png]），失败返回空
     * 响应QQ	文本型	机器人QQ
     * 上传类型	整数型	1好友、临时会话 2群、讨论组 Ps：好友临时会话用类型 1，群讨论组用类型 2；当填写错误时，图片GUID发送不会成功
     * 参考对象	文本型	上传该图片所属的群号或QQ
     * 图片地址	文本型	本地路径或者网络图片地址
     */
    API_UPLOAD_PIC("Api_UpLoadPic", String.class, HttpMethod.POST),
    /**
     * Api_JoinGroup	布尔型	申请加群.为了避免广告、群发行为。出现验证码时将会直接失败不处理
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲申请加入的群号
     * 附加理由	文本型	附加理由，可留空（需回答正确问题时，请填写问题答案）
     */
    API_JOIN_GROUP("Api_JoinGroup", Boolean.class, HttpMethod.POST),
    /**
     * Api_QuitGroup	无返回值	退群
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲退出的群号
     */
    API_QUIT_GROUP("Api_QuitGroup", Void.class, HttpMethod.POST),
    /**
     * Api_SendVoice	布尔型	好友语音上传并发送 （成功返回真 失败返回假）
     * 响应QQ	文本型	机器人QQ
     * 接收QQ	文本型	接收语音人QQ
     * 语音文件	文本型	语音文件路径（AMR Silk编码）
     */
    API_SEND_VOICE("Api_SendVoice", Boolean.class, HttpMethod.POST),
    /**
     * Api_AddFriend	布尔型	主动加好友 成功返回真 失败返回假 当对象设置需要正确回答问题或不允许任何人添加时无条件失败
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	加谁
     * 附加理由	文本型	加好友提交的理由
     */
    API_ADD_FRIEND("Api_AddFriend", Boolean.class, HttpMethod.POST),
    /**
     * Api_AddBkList	无返回值	将好友拉入黑名单
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	被拉黑对象
     */
    API_ADD_BK_LIST("Api_AddBkList", Void.class, HttpMethod.POST),
    /**
     * Api_DelBkList	无返回值	解除好友黑名单
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	解除对象
     */
    API_DEL_BK_LIST("Api_DelBkList", Void.class, HttpMethod.POST),
    /**
     * Api_Shutup	布尔型	禁言群成员
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	禁言对象所在群.
     * 对象	文本型	禁言对象.留空为全群禁言
     * 时长	整数型	单位:秒 最大为1个月. 为零解除对象或全群禁言
     */
    API_SHUT_UP("Api_Shutup", Boolean.class, HttpMethod.POST),
    /**
     * Api_IsShutup	布尔型	根据群号+QQ判断指定群员是否被禁言 获取失败的情况下亦会返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲查询的群号
     * 对象QQ	文本型	需要查询的对象QQ
     */
    API_IS_SHUT_UP("Api_IsShutup", Boolean.class, HttpMethod.POST),
    /**
     * Api_SetAnon	布尔型	开关群匿名消息发送功能 成功返回真 失败返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	需开关群匿名功能群号
     * 开关	逻辑型	真开 假关
     */
    API_SET_ANON("Api_SetAnon", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetDisGroupList	文本型	取出讨论组列表 （返回格式为 换行符分割开的）
     * 响应QQ	文本型	机器人QQ
     */
    API_GET_DIS_GROUP_LIST("Api_GetDisGroupList", String.class, HttpMethod.POST),
    /**
     * Api_GetDisGroupMemberList	文本型	取出讨论组成员列表 （返回格式为 换行符分割开的）
     * 响应QQ	文本型	机器人QQ
     * 讨论组ID	文本型	需获取的讨论组ID
     */
    API_GET_DIS_GROUP_MEMBER_LIST("Api_GetDisGroupMemberList", String.class, HttpMethod.POST),
    /**
     * Api_ShakeWindow	布尔型	向好友发起窗口抖动（戳一戳），调用此Api腾讯会限制频率
     * 响应QQ	文本型	机器人QQ
     * 接收QQ	文本型	接收的QQ
     */
    API_SHAKE_WINDOW("Api_ShakeWindow", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetObjInfo	文本型	获取对象资料 此方式为http，调用时应自行注意控制频率（成功返回JSON格式自行解析）
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_OBJ_INFO("Api_GetObjInfo", String.class, HttpMethod.POST),
    /**
     * Api_DelFriend	布尔型	删除好友 成功返回真 失败返回假
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	被删除对象
     */
    API_DEL_FRIEND("Api_DelFriend", Boolean.class, HttpMethod.POST),
    /**
     * Api_SetShieldedGroup	无返回值	屏蔽或接收某群消息
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	无
     * 类型	整数型	1接收群消息 2收进群助手且不提醒 3屏蔽群消息 4为接收群消息但不提醒
     */
    API_SET_SHIELDED_GROUP("Api_SetShieldedGroup", Void.class, HttpMethod.POST),
    /**
     * Api_SetAdmin	整数型	设置或取消群管理员，成功返回1，失败返回0
     * 响应QQ	文本型	无
     * 群号	文本型	无
     * 对象QQ	文本型	无
     * 操作方式	整数型	1为设置管理，0为取消管理
     */
    API_SET_ADMIN("Api_SetAdmin", Integer.class, HttpMethod.POST),
    /**
     * Api_WithdrawMsg	文本型	消息撤回（成功返回空，失败返回腾讯给出的理由）
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	需撤回消息群号
     * 消息序号	文本型	需撤回消息序号
     * 消息ID	文本型	需撤回消息ID
     */
    API_WITHDRAW_MSG("Api_WithdrawMsg", String.class, HttpMethod.POST),
    /**
     * Api_BeInput	无返回值	置正在输入状态（发送消息后会打断状态）
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	置正在输入状态接收对象
     */
    API_BE_INPUT("Api_BeInput", Void.class, HttpMethod.POST),
    /**
     * Api_GetQQAddMode	文本型	取对象好友添加验证方式 （00 允许任何人 01 需要身份验证 03 需回答正确问题 04 需回答问题 99 已经是好友）
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	需获取对象QQ
     */
    API_GET_QQ_ADD_MODE("Api_GetQQAddMode", String.class, HttpMethod.POST),
    /**
     * Api_GetOnlineState	整数型	查询对象在线状态 返回 1、在线 2、Q我 3、离开 4、忙碌 5、勿扰 6、隐身或离线
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	需获取对象QQ
     */
    API_GET_ONLINE_STATE("Api_GetOnlineState", Integer.class, HttpMethod.POST),
    /**
     * Api_GetGroupMemberNum	文本型	查询对象群当前人数和上限人数，返回格式为：群人数/群上限
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	需查询的群号
     */
    API_GET_GROUP_MEMBER_NUM("Api_GetGroupMemberNum", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupCard	文本型	取对象群名片
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     * 对象QQ	文本型	欲取得群名片的QQ号码
     */
    API_GET_GROUP_CARD("Api_GetGroupCard", String.class, HttpMethod.POST),
    /**
     * Api_AddQQ	布尔型	向框架帐号列表添加一个Q.当该Q已存在时则覆盖密码
     * 帐号	文本型	机器人QQ
     * 密码	文本型	机器人密码
     */
    API_ADD_QQ("Api_AddQQ", Boolean.class, HttpMethod.POST),
    /**
     * Api_DelQQ	无返回值	删除框架帐号列表内指定QQ，不可在执行登录过程中删除QQ否则有几率引起错误
     * 响应QQ	文本型	机器人QQ
     */
    API_DEL_QQ("Api_DelQQ", Void.class, HttpMethod.POST),
    /**
     * Api_Login	布尔型	登录指定QQ，应确保QQ号码在列表中已存在
     * 响应QQ	文本型	机器人QQ
     */
    API_LOGIN("Api_Login", Boolean.class, HttpMethod.POST),
    /**
     * Api_Logout	无返回值	令指定QQ下线，应确保QQ号码已在列表中且在线
     * 响应QQ	文本型	机器人QQ
     */
    API_LOG_OUT("Api_Logout", Void.class, HttpMethod.POST),
    /**
     * Api_IfFriend	布尔型	是否QQ好友（双向） 好友返回真 非好友或获取失败返回假
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	需获取对象QQ
     */
    API_IF_FRIEND("Api_IfFriend", Boolean.class, HttpMethod.POST),
    /**
     * Api_UpVote	文本型	调用一次点一下，成功返回空，失败返回理由如：每天最多给他点十个赞哦，调用此Api时应注意频率，每人每日可被赞10次，每日每Q最多可赞50人
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	填写被赞人QQ
     */
    API_UP_VOTE("Api_UpVote", String.class, HttpMethod.POST),
    /**
     * Api_GetQQLevelInfo	文本型	获取等级 活跃天数 升级剩余活跃天数，成功返回json
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_QQ_LEVEL_INFO("Api_GetQQLevelInfo", String.class, HttpMethod.POST),
    /**
     * Api_TeaEncrypt	文本型	Tea加密
     * 需加密内容	文本型	需加密的内容
     * KEY	文本型	无
     */
    API_TEA_ENCRYPT("Api_TeaEncrypt", String.class, HttpMethod.POST),
    /**
     * Api_TeaDecrypt	文本型	Tea解密
     * 需解密内容	文本型	需解密的内容
     * KEY	文本型	无
     */
    API_TEA_DECRYPT("Api_TeaDecrypt", String.class, HttpMethod.POST),
    /**
     * Api_GNGetGid	文本型	群号转群ID
     * 群号	文本型	无
     */
    API_GN_GET_GID("Api_GNGetGid", String.class, HttpMethod.POST),
    /**
     * Api_GidGetGN	文本型	群ID转群号
     * 群ID	文本型	无
     */
    API_GN_GET_GN("Api_GidGetGN", String.class, HttpMethod.POST),
    /**
     * Api_SetGroupCard	布尔型	修改对象群名片 成功返回真 失败返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	对象所处群号
     * 对象QQ	文本型	被修改名片人QQ
     * 名片	文本型	需要修改的名片
     */
    API_SET_GROUP_CARD("Api_SetGroupCard", Boolean.class, HttpMethod.POST),
    /**
     * Api_KickGroupMBR	无返回值	将对象移除群
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	被执行群号
     * 对象QQ	文本型	被执行对象
     * 不再接收加群请求	逻辑型	真为不再接收，假为接收
     */
    API_KICK_GROUP_MBR("Api_KickGroupMBR", Void.class, HttpMethod.POST),
    /**
     * Api_QuitDisGroup	无返回值	退出讨论组
     * 响应QQ	文本型	机器人QQ
     * 讨论组ID	文本型	需退出的讨论组ID
     */
    API_QUIT_DIS_GROUP("Api_QuitDisGroup", Void.class, HttpMethod.POST),
    /**
     * Api_KickDisGroupMBR	无返回值	将对象移除讨论组
     * 响应QQ	文本型	机器人QQ
     * 讨论组ID	文本型	需执行的讨论组ID
     * 对象QQ	文本型	被执行对象
     */
    API_KICK_DIS_GROUP("Api_KickDisGroupMBR", Void.class, HttpMethod.POST),
    /**
     * Api_SetDisGroupName	无返回值	修改讨论组名称
     * 响应QQ	文本型	机器人QQ
     * 讨论组ID	文本型	需执行的讨论组ID
     * 讨论组名称	文本型	需修改的名称
     */
    API_SET_DIS_GROUP_NAME("Api_SetDisGroupName", Void.class, HttpMethod.POST),
    /**
     * Api_SetFriendsRemark	无返回值	修改好友备注姓名
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	需获取对象好友QQ
     * 备注	文本型	需要修改的备注姓名
     */
    API_SET_FRIENDS_REMARK("Api_SetFriendsRemark", Void.class, HttpMethod.POST),
    /**
     * Api_GetFriendsRemark	文本型	取好友备注姓名（成功返回备注，失败或无备注返回空）
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	需获取对象好友QQ
     */
    API_GET_FRIENDS_REMARK("Api_GetFriendsRemark", String.class, HttpMethod.POST),
    /**
     * Api_SendPack	文本型	向服务器发送原始封包（成功返回服务器返回的包 失败返回空）
     * 响应QQ	文本型	机器人QQ
     * 封包	文本型	封包内容
     */
    API_SEND_PACK("Api_SendPack", String.class, HttpMethod.POST),
    /**
     * Api_GetQQList	文本型	取框架所有QQ列表 包括未登录以及登录失败的QQ 换行符分割
     */
    API_GET_QQ_LIST("Api_GetQQList", String.class, HttpMethod.POST),
    /**
     * Api_GetOnlineQQlist	文本型	取框架在线可用的QQ列表 换行符分割
     */
    API_GET_ONLINE_QQ_LIST("Api_GetOnlineQQlist", String.class, HttpMethod.POST),
    /**
     * Api_GetOffLineList	文本型	取框架离线QQ列表 换行符分割
     */
    API_GET_OFFLINE_LIST("Api_GetOffLineList", String.class, HttpMethod.POST),
    /**
     * Api_GetExpertDays	整数型	查询对象或自身QQ达人天数（返回实际天数 失败返回-1）
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	需查询对象或机器人QQ
     */
    API_GET_EXPERT_DAYS("Api_GetExpertDays", Integer.class, HttpMethod.POST),
    /**
     * Api_PBGroupNotic	布尔型	发布群公告，调用此API应保证响应QQ为管理员
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲发布公告的群号
     * 标题	文本型	公告标题
     * 内容	文本型	公告内容
     */
    API_PB_GROUP_NOTIC("Api_PBGroupNotic", Boolean.class, HttpMethod.POST),
    /**
     * Api_GiveGift	文本型	送群礼物（返回Json格式）
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	需送礼物群号
     * 对象QQ	文本型	赠予礼物对象
     * pid	文本型	礼物pid
     */
    API_GIVE_GIFT("Api_GiveGift", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupChatLv	文本型	查询对象或自身群聊等级（返回实际等级 失败返回空）
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	查询群号
     * 对象QQ	文本型	需查询对象或机器人QQ
     */
    API_GET_GROUP_CHAT_LV("Api_GetGroupChatLv", String.class, HttpMethod.POST),
    /**
     * Api_PBHomeWork	文本型	QQ群作业发布（返回Json格式）
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	需要发布的群号
     * 作业名	文本型	无
     * 标题	文本型	无
     * 内容	文本型	无
     */
    API_PB_HOMEWORK("Api_PBHomeWork", String.class, HttpMethod.POST),
    /**
     * 管理员邀请对象入群，频率过快会失败
     * 响应QQ	String	机器人QQ
     * 群号	String	被邀请加入的群号
     * 对象QQ	String	被邀请人QQ号码（多个号码使用 #换行符 分割）
     */
    API_ADMIN_INVITE_GROUP("Api_AdminInviteGroup", Void.class, HttpMethod.POST),
    /**
     * Api_NoAdminInviteGroup	无返回值	非管理员邀请对象入群，频率过快会失败
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	被邀请加入的群号
     * 对象QQ	文本型	被邀请人QQ号码（多个号码使用 #换行符 分割）
     */
    API_NO_ADMIN_INVITE_GROUP("Api_NoAdminInviteGroup", Void.class, HttpMethod.POST),
    /**
     * Api_GetGender	整数型	取对象性别 1男 2女 未知或失败返回-1
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_GENDER("Api_GetGender", Integer.class, HttpMethod.POST),
    /**
     * Api_GetQQAge	整数型	取Q龄 成功返回Q龄 失败返回-1
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_QQ_AGE("Api_GetQQAge", Integer.class, HttpMethod.POST),
    /**
     * Api_GetAge	整数型	取年龄 成功返回年龄 失败返回-1
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_AGE("Api_GetAge", Integer.class, HttpMethod.POST),
    /**
     * Api_GetEmail	文本型	取邮箱，获取对象QQ资料内邮箱栏为邮箱时返回
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_EMAIL("Api_GetEmail", String.class, HttpMethod.POST),

    /**
     * Api_SetSign	无返回值	设置个人签名
     * 响应QQ	文本型	机器人QQ
     * 签名	文本型	无
     */
    API_SET_SIGN("Api_SetSign", Void.class, HttpMethod.POST),
    /**
     * Api_SetGender	无返回值	设置机器人性别
     * 响应QQ	文本型	机器人QQ
     * 性别	文本型	“1”为男 “2”为女
     */
    API_SET_GENDER("Api_SetGender", Void.class, HttpMethod.POST),
    /**
     * Api_SetNick	无返回值	设置机器人昵称
     * 响应QQ	文本型	机器人QQ
     * 昵称	文本型	需要设置的昵称
     */
    API_SET_NICK("Api_SetNick", Void.class, HttpMethod.POST),

    /**
     * Api_HandleFriendEvent	无返回值	某人请求添加好友验证处理
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	请求添加好友人QQ
     * 处理方式	整数型	10同意 20拒绝 30忽略
     * 附加信息	文本型	拒绝添加好友 附加信息
     */
    API_HANDLE_FRIEND_EVENT("Api_HandleFriendEvent", Void.class, HttpMethod.POST),

    /**
     * Api_HandleGroupEvent	无返回值	某人请求加入群聊验证处理
     * 响应QQ	文本型	机器人QQ
     * data	文本型	MQ_原始信息
     * 处理方式	整数型	10同意 20拒绝 30或0忽略
     * 附加信息	文本型	拒绝时的附加信息
     * 拒绝不再接受	整数型	1为真，慎用
     */
    API_HANDLE_GROUP_EVENT("Api_HandleGroupEvent", Void.class, HttpMethod.POST),

    /**
     * Api_CreateDisGroup	文本型	创建一个讨论组 成功返回讨论组ID 失败返回原因
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_CREATE_DIS_GROUP("Api_CreateDisGroup", String.class, HttpMethod.POST),
    /**
     * Api_InviteDisGroup	文本型	邀请对象加入讨论组 成功返回空 失败返回理由
     * 响应QQ	文本型	机器人QQ
     * 讨论组ID	文本型	需执行的讨论组ID
     * 邀请对象QQ	文本型	被邀请对象QQ 多个用,分割
     */
    API_INVITE_DIS_GROUP("Api_InviteDisGroup", String.class, HttpMethod.POST),


    /**
     * Api_GetPerExp	文本型
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_PER_EXP("Api_GetPerExp", String.class, HttpMethod.POST),
    /**
     * Api_GetSign	文本型
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_SIGN("Api_GetSign", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupName	文本型	取QQ群名
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     */
    API_GET_GROUP_NAME("Api_GetGroupName", String.class, HttpMethod.POST),
    /**
     * Api_UpVoteEx	文本型	调用一次点一下，成功返回空，失败返回理由如：每天最多给他点十个赞哦，调用此Api时应注意频率，每人每日可被赞10次，每日每Q最多可赞50人
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	填写被赞人QQ
     */
    API_UP_VOTE_EX("Api_UpVoteEx", String.class, HttpMethod.POST),
    /**
     * Api_UpLoad	布尔型
     * 响应QQ	文本型	机器人QQ
     * 图片地址	文本型	本地图片路径或者网络图片地址
     */
    API_UPLOAD("Api_UpLoad", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetGroupAddMode	整数型	1允许任何人 2需要验证消息 3不允许任何人加群 4需要正确回答问题 5需要回答问题并由管理员审核 6付费群 0群号不存在
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	无
     */
    API_GET_GROUP_ADD_MODE("Api_GetGroupAddMode", Integer.class, HttpMethod.POST),
    /**
     * Api_红包_K歌红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	群发就填群号，私发就填QQ(讨论组视为群)
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 祝福语	文本型	恭喜发财
     * 类型	整数型	1好友;2群，默认群(讨论组视为群)
     * 歌曲id	文本型	默认124
     */
    API_RED_PACKET_K_MUSIC_RED_PACKET("Api_红包_K歌红包", String.class, HttpMethod.POST),
    /**
     * Api_红包_红包记录	文本型	成功返回为json，自行解析，失败返回为原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 年份	文本型	留空便为当年年份
     * 查询类型	整数型	无
     * 第几页	整数型	无
     */
    API_RED_PACKET_RECORD("Api_红包_红包记录", String.class, HttpMethod.POST),
    /**
     * Api_红包_查询余额	文本型	成功返回json，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     */
    API_RED_PACKET_QUERY_BALANCE("Api_红包_查询余额", String.class, HttpMethod.POST),
    /**
     * Api_红包_转账	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	对方QQ
     * 对象昵称	文本型	对方的昵称，可随便填
     * 金额	文本型	金额，注意，非好友转账最低1元
     * 留言	文本型	万事顺心
     * 非好友转账	逻辑型	是否非好友转账，注意，非好友转账最低1元
     */
    API_RED_PACKET_TRANSFER_ACCOUNTS("Api_红包_转账", String.class, HttpMethod.POST),
    /**
     * Api_红包_口令红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	群发就填群号，私发就填QQ(讨论组视为群)
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 口令	文本型	我是大傻子
     * 类型	整数型	1好友;2群，默认群(讨论组视为群)
     */
    API_RED_PACKET_COMMAND_RED_PACKET("Api_红包_口令红包", String.class, HttpMethod.POST),
    /**
     * Api_红包_拼手气红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	(讨论组视为群)
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 祝福语	文本型	恭喜发财
     */
    API_RED_PACKET_SPELL_LUCK_RED_PACKET("Api_红包_拼手气红包", String.class, HttpMethod.POST),
    /**
     * Api_红包_普通红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	群发就填群号，私发就填QQ(讨论组视为群)
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 祝福语	文本型	恭喜发财
     * 类型	整数型	1好友;2群;3群临时会话，默认群(讨论组视为群)
     * 讨论组群号	文本型	当类型为3时，要提供临时会话的群号
     */
    API_RED_PACKET_COMMON_RED_PACKET("Api_红包_普通红包", String.class, HttpMethod.POST),
    /**
     * Api_红包_引力球红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	群发就填群号，私发就填QQ(讨论组视为群)
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 祝福语	文本型	恭喜发财
     * 类型	整数型	1好友;2群;3群临时会话，默认群(讨论组视为群)
     * 挑战分数	文本型	必须为正整数，默认100，错误的值强制100
     */
    API_RED_PACKET_GRAVITY_RED_PACKET("Api_红包_引力球红包", String.class, HttpMethod.POST),
    /**
     * Api_红包_语音红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 对象	文本型	群发就填群号，私发就填QQ(讨论组视为群)
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 口令	文本型	我是傻子
     * 类型	整数型	1好友;2群;3群临时会话，默认群(讨论组视为群)
     */
    API_RED_PACKET_VOICE_RED_PACKET("Api_红包_语音红包", String.class, HttpMethod.POST),
    /**
     * Api_红包_专享红包	文本型	成功返回success，失败返回失败原因
     * 机器人QQ	文本型	无
     * 支付密码	文本型	无
     * 群号	文本型	(讨论组视为群)
     * 对象	文本型	对方的QQ
     * 数量	文本型	个数
     * 金额	文本型	金额
     * 祝福语	文本型	恭喜发财
     */
    API_RED_PACKET_EXCLUSIVE_RED_PACKET("Api_红包_专享红包", String.class, HttpMethod.POST),
    /**
     * Api_Reload	无返回值	重载自身
     * path	文本型	新路径
     */
    API_RELOAD("Api_Reload", Void.class, HttpMethod.POST),
    /**
     * Api_GetQQLevel	文本型	获取等级，成功返回等级
     * 响应QQ	文本型	机器人QQ
     * 对象QQ	文本型	无
     */
    API_GET_QQ_LEVEL("Api_GetQQLevel", String.class, HttpMethod.POST),
    /**
     * Api_ShutupGroup	布尔型	置全群禁言
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	欲操作的群号
     * 开关	整数型	1为开启，0为解除
     */
    API_SHUT_UP_GROUP("Api_ShutupGroup", Boolean.class, HttpMethod.POST),
    /**
     * Api_SearchGroup	文本型	搜索群，返回原始json
     * 响应QQ	文本型	机器人QQ
     * 关键词	文本型	无
     * 页数	整数型	无
     */
    API_SEARCH_GROUP("Api_SearchGroup", String.class, HttpMethod.POST),

    /**
     * Api_PubSay	整数型	发表说说，成功返回1，失败返回0
     * 响应QQ	文本型	机器人QQ
     * 说说内容	文本型	无
     */
    API_PUB_SAY("Api_PubSay", Integer.class, HttpMethod.POST),
    /**
     * Api_Mp3ToAmr	文本型	请确保bin目录有ffmpeg转码库(框架不自带)，成功返回amr文件完整路径，可直接调用上传语音api，失败返回空
     * mp3文件路径	文本型	mp3文件路径
     * amr文件路径	文本型	amr文件存放路径
     */
    API_MP3_TO_AMR("Api_Mp3ToAmr", String.class, HttpMethod.POST),

    /**
     * Api_CreateGroup_A	文本型	成功返回群号等信息，http模式创建群聊，请注意调用频率
     * 响应QQ	文本型	机器人QQ
     * 群名称	文本型	无
     * 群类别	文本型	如：10048=行业交流
     */
    API_CREATE_GROUP_A("Api_CreateGroup_A", String.class, HttpMethod.POST),

    /**
     * Api_PublishVote_A	文本型	发起群投票_单选，返回投票fid
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	无
     * 标题	文本型	无
     * 选项1	文本型	无
     * 选项2	文本型	无
     * 选项3	文本型	无
     * 截止日期十位时间戳	文本型	截止日期十位时间戳
     * 是否匿名	文本型	1为匿名 0为不匿名
     */
    API_PUBLISH_VOTE_A("Api_PublishVote_A", String.class, HttpMethod.POST),
    /**
     * Api_PublishVote_B	文本型	发起群投票_多选，返回投票fid
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	无
     * 标题	文本型	无
     * 选项1	文本型	无
     * 选项2	文本型	无
     * 选项3	文本型	无
     * 最多选几项	文本型	填写最多可选几项
     * 截止日期十位时间戳	文本型	截止日期十位时间戳
     * 是否匿名	文本型	1为匿名 0为不匿名
     */
    API_PUBLISH_VOTE_B("Api_PublishVote_B", String.class, HttpMethod.POST),
    /**
     * Api_GetAnon	整数型	查询群是否支持匿名聊天
     * 响应QQ	文本型	机器人QQ
     * 目标群号	文本型	无
     */
    API_GET_ANON("Api_GetAnon", Integer.class, HttpMethod.POST),
    /**
     * Api_InviteGroup_other	整数型	邀请别人群成员加入自己群
     * 响应QQ	文本型	机器人QQ
     * 目标群号	文本型	被邀请加入的群号
     * 所在群号	文本型	被邀请人和机器人共同存在的群号
     * 对象QQ	文本型	被邀请人QQ号码（多个号码使用 换行符 分开）
     */
    API_INVITE_GROUP_OTHER("Api_InviteGroup_other", Integer.class, HttpMethod.POST),
    /**
     * Api_SetMsgEssence	文本型	返回结果请调试查看：机器人非管理员，禁止设置精华消息
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	需设置的群号
     * 消息序号	文本型	需设置的消息序号
     * 消息ID	文本型	需设置的消息ID
     */
    API_SET_MSG_ESSENCE("Api_SetMsgEssence", String.class, HttpMethod.POST),
    /**
     * Api_UpGroupFile	文本型	发送群文件，成功返回 文件信息 失败返回 空
     * 响应QQ	文本型	机器人QQ
     * 目标群号	文本型	要上传的群号
     * 本地文件路径	文本型	文件的完整路径
     */
    API_UP_GROUP_FILE("Api_UpGroupFile", String.class, HttpMethod.POST),
    /**
     * Api_UpFriendFile	文本型	发送好友文件，成功返回1 失败返回0
     * 响应QQ	文本型	机器人QQ
     * 发送QQ	文本型	要发送给的谁
     * 本地文件路径	文本型	文件的完整路径
     */
    API_UP_FRIEND_FILE("Api_UpFriendFile", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupMemberInfo	文本型	获取群成员信息，成功返回json
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     * 对象QQ	文本型
     */
    API_GET_GROUP_MEMBER_INFO("Api_GetGroupMemberInfo", String.class, HttpMethod.POST),
    /**
     * Api_CreateGroupPay	文本型	成功返回c_no，失败返回：retmsg=账号未实名认证（可通过寻找文本retmsg判断是否成功）
     * 响应QQ	文本型
     * 群号	文本型
     * 标题	文本型
     * 类型	整数型	1=均摊，2=指定
     * 需支付QQ	文本型	多个用,隔开
     * 需支付金额	文本型	单位分，多人用,隔开，需要和上一个参数保持一致(均摊情况下，每个人的要一样)
     */
    API_CREATE_GROUP_PAY("Api_CreateGroupPay", String.class, HttpMethod.POST),
    /**
     * Api_GetGroupPayDetail	文本型	查询群收钱账单详情，成功返回json，可调用Api_GroupPayIsOk（群收钱账单是否已支付）解析
     * 响应QQ	文本型
     * c_no	文本型	发起群收钱获得的c_no
     */
    API_GET_GROUP_PAY_DETAIL("Api_GetGroupPayDetail", String.class, HttpMethod.POST),
    /**
     * Api_GroupPayIsOk	整数型	群收钱账单是否已支付，已支付返回1，未支付返回0
     * 账单详情json	文本型	查询账单详情获得的json
     * 要查询的QQ	文本型
     */
    API_GROUP_PAY_IS_OK("Api_GroupPayIsOk", Integer.class, HttpMethod.POST),
    /**
     * Api_SendGroupPayMsg	整数型	发送群收钱账单催收通知，成功返回1，失败返回0
     * 响应QQ	文本型
     * c_no	文本型	发起群收钱获得的c_no
     */
    API_SEND_GROUP_PAY_MSG("Api_SendGroupPayMsg", Integer.class, HttpMethod.POST),
    /**
     * Api_SetGroupName	整数型	修改群名称，成功返回1，失败返回0
     * 响应QQ	文本型
     * 群号	文本型
     * 群名	文本型
     */
    API_SET_GROUP_NAME("Api_SetGroupName", Integer.class, HttpMethod.POST),
    /**
     * Api_DelFriend_A	布尔型	删除好友变成单项好友\陌生人 成功返回真 失败返回假
     * 响应QQ	文本型
     * 对象QQ	文本型	被删除对象
     */
    API_DEL_FRIEND_A("Api_DelFriend_A", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetNoticDetail	文本型	获取群公告已阅读人员详情，成功返回json
     * 响应QQ	文本型
     * 群号	文本型	群号
     * 公告FID	文本型	群公告FID
     */
    API_GET_NOTIC_DETAIL("Api_GetNoticDetail", String.class, HttpMethod.POST),
    /**
     * Api_GetShieldedState	文本型	取机器人屏蔽状态，1=正常，0=被屏蔽
     * 响应QQ	文本型
     */
    API_GET_SHIELDED_STATE("Api_GetShieldedState", String.class, HttpMethod.POST),
    /**
     * Api_SetFriendVerify	逻辑型	修改机器人好友验证方式，成功返回真，失败返回假
     * 响应QQ	文本型
     * 验证方式	整数型	1为允许任何人 2为需要验证 3为需要正确回答问题
     * 设置问题	文本型	当验证方式为3时填写问题,其他类型可空
     * 问题答案	文本型	当验证方式为3时填写问题答案,其他类型可空
     */
    API_SET_FRIEND_VERIFY("Api_SetFriendVerify", Boolean.class, HttpMethod.POST),
    /**
     * Api_AddGroupRobot	逻辑型	成功返回真，失败返回假，可能为频率过快，机器人已存在等原因
     * 响应QQ	文本型
     * 群号	文本型	群号
     * 腾讯机器人QQ	文本型	详情见文档
     */
    API_ADD_GROUP_ROBOT("Api_AddGroupRobot", Boolean.class, HttpMethod.POST),
    /**
     * Api_DelGroupRobot	逻辑型	成功返回真，失败返回假，可能为频率过快，机器人已不存在等原因
     * 响应QQ	文本型
     * 群号	文本型	群号
     * 腾讯机器人QQ	文本型	详情见文档
     */
    API_DEL_GROUP_ROBOT("Api_DelGroupRobot", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetSchool	文本型	取学校，获取对象QQ资料内学校栏
     * 响应QQ	文本型
     * 对象QQ	文本型
     */
    API_GET_SCHOOL("Api_GetSchool", String.class, HttpMethod.POST),
    /**
     * Api_GetCompany	文本型	取公司，获取对象QQ资料内公司栏
     * 响应QQ	文本型
     * 对象QQ	文本型
     */
    API_GET_COMPANY("Api_GetCompany", String.class, HttpMethod.POST),
    /**
     * Api_CreatQrCodeInfo	文本型	获取登录二维码，成功返回{"status":"200","msg":"用QQ手机版扫描二维码安全登录。","qr_id":"MyQQ-1","qr_file":"1626880321974.png"}
     */
    API_CREAT_QR_CODE_INFO("Api_CreatQrCodeInfo", String.class, HttpMethod.POST),
    /**
     * Api_GetQrCodeStatus	整数型	获取二维码登录状态，返回状态有：1=确认成功，正在登陆 2=登录成功 3=扫描成功，请在手机上点击确认 4=二维码失效，请重新申请 5=未申请二维码 6=等待扫码
     * qr_id	文本型
     */
    API_CREAT_QR_CODE_STATUS("Api_GetQrCodeStatus", Integer.class, HttpMethod.POST),
    /**
     * Api_CloseQrCode	文本型	取消二维码登录
     * qr_id	文本型
     */
    API_CLOSE_QR_CODE("Api_CloseQrCode", String.class, HttpMethod.POST),
    /**
     * Api_GetQrCodePath	文本型（HTTPAPI不必使用）获取二维码图片的本地路径，返回为：C:\Users\13301\Desktop\开发\MyQQ\MyQQ_Dev\data\cache\1626880321974.png
     * qr_file	文本型
     */
    API_GET_QR_CODE_PATH("Api_GetQrCodePath", String.class, HttpMethod.POST),
    /**
     * Api_GetQrQQNumber	文本型	扫码登陆成功后可调用此API获取登录的QQ号
     * qr_file	文本型
     */
    API_GET_QR_QQ_NUMBER("Api_GetQrQQNumber", Integer.class, HttpMethod.POST),
    /**
     * Api_JoinGroupEx	文本型	返回格式为：是否成功=真&短信标识=短信标识，如果短信标识不为空，就是需要短信，调用取短信详情（Api_GetJoinGroupMsg）获取短信详情
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型
     * 理由	文本型
     * 接口	文本型	接口 0=随机，1=搜索群号、2=附近的群、3=通知界面加群、4=链接加群、5=关键词、6=精确查找
     * 通道	文本型	通道 0=随机，1=新版，2=老版
     */
    API_JOIN_GROUP_EX("Api_JoinGroupEx", String.class, HttpMethod.POST),
    /**
     * Api_GetJoinGroupMsg	文本型	返回json文本 含有需发送至短信号码 短信内容,{"SendMsgNumber":"1888666666","SendMsgToNumber":"1069***794","MsgText":"***"}
     * 响应QQ	文本型	机器人QQ
     * 短信标识	文本型
     */
    API_GET_JOIN_GROUP_MSG("Api_GetJoinGroupMsg", String.class, HttpMethod.POST),
    /**
     * Api_CheckJoinGroupMsg	文本型	发送短信后，调用此API查询是否加群成功，成功返回真，失败返回假
     * 响应QQ	文本型	机器人QQ
     * 短信标识	文本型
     */
    API_CHECK_JOIN_GROUP_MSG("Api_CheckJoinGroupMsg", String.class, HttpMethod.POST),
    /**
     * Api_SetGroupTempSession	逻辑型	置群成员发起临时会话开关，成功返回真，失败返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     * 开关	文本型	1=允许，0=禁止
     */
    API_SET_GROUP_TEMP_SESSION("Api_SetGroupTempSession", Boolean.class, HttpMethod.POST),
    /**
     * Api_SetGroupLaunchNew	逻辑型	置群成员发起群聊开关，成功返回真，失败返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     * 开关	文本型	1=允许，0=禁止
     */
    API_SET_GROUP_LAUNCH_NEW("Api_SetGroupLaunchNew", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetGroupTempSession	逻辑型	取是否允许群成员发起临时会话，允许返回真，禁止返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     */
    API_GET_GROUP_TEMP_SESSION("Api_GetGroupTempSession", Boolean.class, HttpMethod.POST),
    /**
     * Api_GetGroupLaunchNew	逻辑型	取是否允许群成员发起群聊，允许返回真，禁止返回假
     * 响应QQ	文本型	机器人QQ
     * 群号	文本型	群号
     */
    API_GET_GROUP_LAUNCH_NEW("Api_GetGroupLaunchNew", Boolean.class, HttpMethod.POST),
    /**
     * Api_InviteGroup_otherEx	逻辑型	邀请别人群成员加入自己群，多群版,成功返回1，失败返回0
     * 响应QQ	文本型	机器人QQ
     * 目标群号	文本型	被邀请加入的群号
     * 群和QQ	文本型	被邀请人和机器人共同存在的群号，格式为：QQ,群号|QQ,群号|QQ,群号
     */
    API_INVITE_GROUP_OTHER_EX("Api_InviteGroup_otherEx", Boolean.class, HttpMethod.POST),
    ;


    private final String apiFunctionName;
    private final Class<?> returnValueType;
    private final HttpMethod httpMethod;
}
