package com.linq.cool.qqbot.myqq.utils.myutils;

import com.linq.cool.qqbot.myqq.callback.MyQQMessageCallbackRequest;
import com.linq.cool.qqbot.myqq.enums.MyQQCommandEnum;
import com.linq.cool.qqbot.myqq.utils.regex.RegexRule;
import com.linq.cool.qqbot.myqq.utils.regex.RegexUtils;
import lombok.extern.slf4j.Slf4j;


import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuris
 * @create 2024-04-18-17:21
 */
@Slf4j
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

    public static String toGBK(String Umsg) {
        try {
            byte[] utf8Bytes = Umsg.getBytes("UTF-8");
            String gkbString = new String(utf8Bytes, Charset.forName("gbk"));
            return gkbString;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMsgContent(MyQQMessageCallbackRequest callbackRequest){
        String message = callbackRequest.getMsg();
        String robotQQ = callbackRequest.getRobotQQ();
        Pattern pattern = Pattern.compile("(?<=\\[@"+robotQQ+"])[\\s\\S]*");
        Matcher matcher = pattern.matcher(message);
        pattern = Pattern.compile("(?<=用户：鱼竿儿 )[\\s\\S]*"); //我的机器人的群名
        Matcher matcher1 = pattern.matcher(message);
        String result=null;
        if(matcher.find()){
            result = matcher.group();
            log.info("消息: {}",result);
        }else if(matcher1.find()){
            result = matcher1.group();
            log.info("消息: {}",result);
        }else{
            log.info("没有匹配到信息");
        }
        return result;
    }

    public static String GetSpecifiedContent(String content,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if(matcher.find()){
            String result = matcher.group();
            log.info("消息: {}",result);
            return result;
        }
        log.info("没有匹配到信息");
        return null;
    }

}
