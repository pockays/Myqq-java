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
            return "我是只属于主人的鱼竿儿哦~" ;
        }
       String Content =  MyUtil.getMsgContent(callbackRequest).trim();
        switch (Content){
            case "起床了":
                if(jobService.getCronTrigger()!=null||jobService.getSimpleTrigger()!=null){
                    reponse = "在钓了，在钓了";
                    break;
                }
                try {
                    jobService.startbyinterval("fishjob","Group",0, FishJob.class,callbackRequest.getFromId(),callbackRequest.getRobotQQ(),false);
                }
                catch (SchedulerException e){
                    e.printStackTrace();
                }
                reponse = "钓鱼，启动！";
                break;
            case "加班" :
                if(jobService.getSimpleTrigger()!=null){
                    jobService.delete("fishjob","Group");
                }
                try {
                    jobService.startbyinterval("fishjob","Group",0, FishJob.class,callbackRequest.getFromId(),callbackRequest.getRobotQQ(),true);
                }
                catch (SchedulerException e){
                    e.printStackTrace();
                }
                reponse = "黑心老板坏坏";
                break;
            case "社畜模式":
                if(jobService.getSimpleTrigger()!=null){
                    jobService.delete("fishjob","Group");
                }
                try {
                    jobService.startbycron("fishjob","Group","0 0/30 8-18 * * ?", FishJob.class,callbackRequest.getFromId(),callbackRequest.getRobotQQ());
                }
                catch (SchedulerException e){
                    e.printStackTrace();
                }
                reponse = "已切换社畜模式";
                break;
            case "睡吧":
                jobService.pause("Group","fishjob");
                reponse = "(¦3[▓▓]";
                break;
            default:
                reponse= null;
        }
        if(Content.contains("本次耗时")||Content.contains("浪费")||Content.contains("间隔时间")){
            if(jobService.getSimpleTrigger()==null){
                return "诶~还没开始钓呢";
            }
            String costTime = RegexUtils.parse(Content, new RegexRule.Builder("\\d+分", 0, "分").build());
            if(Content.contains("间隔时间")){
                costTime=String.valueOf(Integer.parseInt(costTime)+1);
            }
            //String cronExpression = "0 0/"+ costTime +" 8-18 * * ?";         ps:根据cron的作用 cron触发器的更新是没意义的
            jobService.update(jobService.getSimpleTrigger(),costTime);
        }
        else if(Content.contains("鱼饵已经用完")){
            reponse = "一键卖鱼";
        }else if(Content.contains("出售成功")){
            reponse = "我的金币";
        }else if(Content.contains("存款：")){
            String num = buyLure(Content);
            reponse = "购买鱼饵 稀有鱼饵 "+ num;
            if(num.equals("0")){
                reponse = "已经没钱嘞o(╥﹏╥)o";
            }
        }else if(Content.contains("购买成功")){
            reponse = "钓鱼";
        }else if(Content.contains("假装看不见")){
            reponse = "假装看不见";
        }else if(Content.contains("逃离了你的魔爪")||Content.contains("春秋大梦")){
            reponse = "钓鱼";
        }else if(Content.contains("发送信息")){
            reponse = MyUtil.GetSpecifiedContent(Content,"(?<=发送信息：)[\\s\\S]*");
        }else if(Content.contains("宝箱")){
            reponse = "钓鱼";
        }
        return reponse;
    }

    private String buyLure(String Content){
        int amount = 0;
        if(Content.contains("万")){
            String money = RegexUtils.parse(Content, new RegexRule.Builder("(?<=积分：)\\d+\\.\\d+万|\\d+万", 0, "万").build());
            double doubleNum = Math.min(Double.parseDouble(money), 2);
            amount = (int)(doubleNum*10000-1000)/2000;
        }else{
            String money =MyUtil.GetSpecifiedContent(Content,"(?<=积分：)\\d+");
            int num = Integer.parseInt(money);
            amount = (int)num/2000;
        }
        return String.valueOf(amount);
    }
}
