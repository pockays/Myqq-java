package com.linq.cool.qqbot.myqq.response.myqq;

import com.linq.cool.qqbot.myqq.callback.MyQQMessageCallbackRequest;
import com.linq.cool.qqbot.myqq.config.MyQQProperties;
import com.linq.cool.qqbot.myqq.job.FishJob;
import com.linq.cool.qqbot.myqq.job.service.JobService;
import com.linq.cool.qqbot.myqq.utils.myutils.MyUtil;
import com.linq.cool.qqbot.myqq.utils.regex.RegexRule;
import com.linq.cool.qqbot.myqq.utils.regex.RegexUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;
/**
 * @author liuris
 * @create 2024-04-18-23:28
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class FishHttpRequestTemplate {
    private final MyQQProperties myQQProperties;
    private  final JobService jobService;
    public String getReplyMessage(MyQQMessageCallbackRequest callbackRequest){
        String fromQQ = callbackRequest.getFromQQ();
        String reponse = null;
        if(!myQQProperties.getMaster().equals(fromQQ) && !myQQProperties.getGrouprobot().equals(fromQQ)){
            return MyUtil.toGBK("我是只属于主人的鱼竿儿哦~") ;
        }
       String Content =  MyUtil.getMsgContent(callbackRequest).trim();
        switch (Content){
            case "钓鱼启动！":
                try {
                    jobService.start("fishjob","Group","0/30 * * * * ?", FishJob.class,callbackRequest.getFromId(),callbackRequest.getRobotQQ());
                }
                catch (SchedulerException e){
                    e.printStackTrace();
                }
                reponse = "启动！";
                break;
            case "睡吧":
                jobService.pause("Group","fishjob");
                reponse = "(¦3[▓▓]";
                break;
            default:
                reponse= "不知道该回你些什么";
        }
        if(Content.contains("本次耗时")){
            String costTime = RegexUtils.parse(Content, new RegexRule.Builder("(?<=本次耗时：).*$", 0, "分钟").build());
            String cronExpression = "0/"+ costTime +" * 8,17 * * ?";
            jobService.update(jobService.getTrigger(),cronExpression);
        }else if(Content.contains("鱼饵已经用完")){
            reponse = "一键卖鱼";
        }else if(Content.contains("出售成功")){
            reponse = "我的金币";
        }else if(Content.contains("积分：")){
            String num = buyLure(Content);
            reponse = "购买鱼饵 稀有鱼饵 "+ num;
        }else if(Content.contains("购买成功")){
            reponse = "钓鱼";
        }
        return MyUtil.toGBK(reponse);
    }

    private String buyLure(String Content){
        int amount = 0;
        if(Content.contains("万")){
            String money = RegexUtils.parse(Content, new RegexRule.Builder("(?<=积分：).*$", 0, "万").build());
            double doubleNum = Double.parseDouble(money);
            amount = (int)(doubleNum*10000-1000)/2000;
        }else{
            String money =MyUtil.GetSpecifiedContent(Content,"(?<=积分：).*$");
            int num = Integer.parseInt(money);
            amount = (int)num/2000;
        }
        return String.valueOf(amount);
    }
}
