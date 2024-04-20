package com.linq.cool.qqbot.myqq.utils;

import com.alibaba.fastjson.JSON;

import com.linq.cool.qqbot.myqq.enums.MyQQApiEnum;
import com.linq.cool.qqbot.myqq.request.MyQQRequest;
import com.linq.cool.qqbot.myqq.response.MyQQResponse;
import com.linq.cool.qqbot.myqq.utils.json.JsonUtils;
import com.mzlion.easyokhttp.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yqlin
 * @date: 2021/7/1 12:01
 * @description:
 */
@Slf4j
public class MyQQHttpRequestUtil {

    /**
     * 调用MyQQ内部函数发送请求获取数据
     *
     * @param method   请求方式 目前封装只需要 POST,GET
     * @param host     MyQQ的ip 地址
     * @param port     MyQQ的ip 端口
     * @param token    MyQQ的token
     * @param function 调用函数名
     * @param args     函数参数
     *
     * @return MyQQResponse
     */
    public static MyQQResponse doRequest(HttpMethod method, String host, String port, String token, String function, Object... args) {
        String url = String.format("http://%s:%s/MyQQHTTPAPI", host, port);
        Map<String, Object> params = new HashMap<>(8);
        if (args.length >= 1) {
            for (int i = 0; i < args.length; i++) {
                params.put(String.format("c%d", i + 1), args[i]);
            }
        }
        String responseString = null;
        switch (method) {
            case GET:
                params.put("function", function);
                params.put("token", token);
                Map<String, String> queryParams = new HashMap<>(8);
                params.keySet().forEach(e -> queryParams.put(e, String.valueOf(params.get(e))));
                log.info("\n\n请求: " + function + "， 请求方式: GET, 请求参数: " + queryParams + "\n\n");
                responseString = HttpClient.get(url)
                        .queryString(queryParams)
                        .asString();
                break;
            case POST:
                MyQQRequest request = new MyQQRequest().setFunction(function).setToken(token).setParams(params);
                log.info("\n\n请求: " + function + "， POST, 请求Json体: " + JsonUtils.printJson(request) + " , 编码: GBK\n\n");
                System.out.println(JSON.toJSONString(request));
                responseString = HttpClient.textBody(url)
                        .json(JSON.toJSONString(request))
                        .charset("utf-8")
                        .asString();
                break;
            default:
                break;
        }
        log.info("\n\n请求: " + function + "， 获取数据: " + responseString + "\n\n");
        return JSON.parseObject(responseString, MyQQResponse.class);
    }

    /**
     * 通过注解进行构建调用MyQQ内部函数发送请求获取数据
     *
     * @param method   请求方式 目前封装只需要 POST,GET
     * @param host     MyQQ的ip 地址
     * @param port     MyQQ的ip 端口
     * @param token    MyQQ的token
     * @param function 调用函数名
     * @param params   参数 {"c1":"","c2":""}
     *
     * @return MyQQResponse
     */
    public static MyQQResponse doRequest(HttpMethod method, String host, String port, String token, String function, Map<String, Object> params) {
        String url = String.format("http://%s:%s/MyQQHTTPAPI", host, port);
        String responseString = null;
        switch (method) {
            case GET:
                params.put("function", function);
                params.put("token", token);
                Map<String, String> queryParams = new HashMap<>(8);
                params.keySet().forEach(e -> queryParams.put(e, String.valueOf(params.get(e))));
                log.info("\n\n请求: " + function + "， 请求方式: GET, 请求参数: " + JsonUtils.printJson(queryParams) + "\n\n");
                responseString = HttpClient.get(url)
                        .queryString(queryParams)
                        .asString();
                break;
            case POST:
                MyQQRequest request = new MyQQRequest().setFunction(function).setToken(token).setParams(params);
                log.info("\n\n请求: " + function + "， POST, 请求Json体: " + JsonUtils.printJson(request) + " , 编码: utf8\n\n");
                responseString = HttpClient.textBody(url)
                        .json(JSON.toJSONString(request))
                        .charset("utf-8")
                        .asString();
                break;
            default:
                break;
        }
        MyQQResponse myQQResponse = JSON.parseObject(responseString, MyQQResponse.class);
        log.info("\n\n请求: " + function + "， 获取数据: " + JsonUtils.printJson(myQQResponse) + "\n\n");
        return myQQResponse;
    }


    public static void main(String[] args) {
        MyQQResponse getResponse = doRequest(HttpMethod.GET, "localhost", "7788", "666", MyQQApiEnum.API_OUT_PUT.getApiFunctionName(), "测试信息");
        System.out.println(getResponse);
        /**
         * args
         * 响应QQ	文本型	机器人QQ
         * 匿名	整数型	0为普通 1为匿名（匿名需要群开启）
         * 信息类型	整数型	1好友 2群
         * 收信群号	文本型	信息类型=2时填写群号，信息类型=1时留空
         * 收信对象	文本型	信息类型=1时填写收信对象QQ，信息类型=2时留空
         * 内容	文本型	信息内容
         * 气泡ID	整数型	（已失效）默认为0使用本来的气泡，-1为随机气泡
         * 982469065
         */
        //        for (int i = 0; i < 1000; i++) {
        //            new Thread(() -> {
        //                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        //                String currentTime = sdf.format(new Date());
        //                String message = String.format("当前时间: %s , 看强哥都是牛皮的!!!!", currentTime);
        //                MyQQResponse postResponse = doRequest(HttpMethod.POST, "localhost", "7788", "666", MyQQApiEnum.API_SEND_MSG_EX.getApiFunctionName(),
        //                                                      "3377894260", null, MyQQTypeEnum.MESSAGE_TYPE_FRIEND.getCode(), null, "1460838887", message, 0
        //                );
        //                System.out.println(postResponse);
        //            }).start();
        //        }

    }
}
