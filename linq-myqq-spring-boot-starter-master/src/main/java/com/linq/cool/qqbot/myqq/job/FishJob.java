package com.linq.cool.qqbot.myqq.job;

import com.linq.cool.qqbot.myqq.enums.MyQQTypeEnum;
import com.linq.cool.qqbot.myqq.request.myqq.MyQQApiSendMsgRequest;
import com.linq.cool.qqbot.myqq.response.MyQQMessageCallbackResponse;
import com.linq.cool.qqbot.myqq.template.MyQQHttpRequestTemplate;
import com.linq.cool.qqbot.myqq.utils.myutils.MyUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author liuris
 * @create 2024-04-19-16:50
 */
@DisallowConcurrentExecution
public class FishJob implements Job {
    @Autowired
    private MyQQHttpRequestTemplate myQQHttpRequestTemplate;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        String GroupId = jobDetail.getJobDataMap().getString("GroupId");
        String RobotQQ = jobDetail.getJobDataMap().getString("Robotqq");
        System.out.println(String.format("key: %s", jobDetail.getKey()));
        try{ //防止正好在钓鱼cd结束的那一刹那发出去
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        myQQHttpRequestTemplate.doRequest(new MyQQApiSendMsgRequest()
                .setInfoType(MyQQTypeEnum.MESSAGE_TYPE_GROUP.getCode())
                .setGroup(GroupId)
                .setRobotQQ(RobotQQ)
                .setContent("钓鱼"), MyQQApiSendMsgRequest.class);
        MyQQMessageCallbackResponse.intercept();
    }
}
