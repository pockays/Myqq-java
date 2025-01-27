package com.linq.cool.qqbot.myqq.command;

import com.linq.cool.qqbot.myqq.annotation.MyQQRobotCommand;
import com.linq.cool.qqbot.myqq.callback.MyQQMessageCallbackRequest;
import com.linq.cool.qqbot.myqq.enums.MyQQTypeEnum;
import com.linq.cool.qqbot.myqq.handler.MyQQRobotCommandHandler;
import com.linq.cool.qqbot.myqq.request.myqq.MyQQApiSendMsgRequest;
import com.linq.cool.qqbot.myqq.response.MyQQMessageCallbackResponse;
import com.linq.cool.qqbot.myqq.response.MyQQResponse;
import com.linq.cool.qqbot.myqq.response.myqq.FishHttpRequestTemplate;
import com.linq.cool.qqbot.myqq.template.MyQQHttpRequestTemplate;
import com.linq.cool.qqbot.myqq.utils.myutils.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuris
 * @create 2024-04-17-20:34
 */
@Slf4j
@MyQQRobotCommand(regex = "\\[@[1-9][0-9]{4,14}][\\s\\S]*")
public class MyQQRobotCommandRobotReplyHandler implements MyQQRobotCommandHandler {
    @Autowired
    private MyQQHttpRequestTemplate myQQHttpRequestTemplate;
    @Autowired
    private FishHttpRequestTemplate fishHttpRequestTemplate;
    @Override
    public MyQQMessageCallbackResponse handle(MyQQMessageCallbackRequest callbackRequest) {
        String message = callbackRequest.getMsg();
        String targetQQ = MyUtil.parseQQ(message);
        MyQQResponse sendMsgResponse;
        log.info("目标QQ: {}", targetQQ);
        if(callbackRequest.getRobotQQ().equals(targetQQ)){
            log.info("监听机器人QQ: {}", callbackRequest.getRobotQQ());
            String fishResponse = fishHttpRequestTemplate.getReplyMessage(callbackRequest);
            if(fishResponse == null){
                return MyQQMessageCallbackResponse.next();
            }
            sendMsgResponse= myQQHttpRequestTemplate.doRequest(new MyQQApiSendMsgRequest()
                    .setInfoType(MyQQTypeEnum.MESSAGE_TYPE_GROUP.getCode())
                    .setGroup(callbackRequest.getFromId())
                    .setRobotQQ(callbackRequest.getRobotQQ())
                    .setContent(fishResponse), MyQQApiSendMsgRequest.class);
            if(sendMsgResponse.getSuccess()){
                return MyQQMessageCallbackResponse.next();
            }
        }
        return MyQQMessageCallbackResponse.intercept();
    }
}
