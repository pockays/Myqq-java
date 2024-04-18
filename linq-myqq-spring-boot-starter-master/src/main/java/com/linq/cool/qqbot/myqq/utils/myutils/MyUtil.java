package com.linq.cool.qqbot.myqq.utils.myutils;

import com.linq.cool.qqbot.myqq.enums.MyQQCommandEnum;
import com.linq.cool.qqbot.myqq.utils.regex.RegexRule;
import com.linq.cool.qqbot.myqq.utils.regex.RegexUtils;

import java.util.regex.Pattern;

/**
 * @author liuris
 * @create 2024-04-18-17:21
 */
public class MyUtil {
    //机器人是否收到信息
    public static boolean isSendMessageToRobot(String receiveMessage) {
        return MyQQCommandEnum.GROUP_AT_MEMBER_COMMAND.getPattern().matcher(receiveMessage).find();
    }

    public static String parseQQ(String receiveMessage) {
        if (isSendMessageToRobot(receiveMessage)) {
            return RegexUtils.parse(receiveMessage, new RegexRule.Builder(MyQQCommandEnum.GROUP_AT_MEMBER_COMMAND.getPattern().pattern(), "\\[@", "[0-9]\\]").build());
        } else {
            return null;
        }
    }
}
