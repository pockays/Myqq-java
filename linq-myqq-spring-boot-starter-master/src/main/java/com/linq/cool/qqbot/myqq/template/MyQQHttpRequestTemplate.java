package com.linq.cool.qqbot.myqq.template;

import com.linq.cool.qqbot.myqq.annotation.RequestArg;
import com.linq.cool.qqbot.myqq.annotation.RequestEntity;
import com.linq.cool.qqbot.myqq.config.MyQQProperties;
import com.linq.cool.qqbot.myqq.enums.InternalUtilEnum;
import com.linq.cool.qqbot.myqq.enums.MyQQApiEnum;
import com.linq.cool.qqbot.myqq.exception.UtilException;
import com.linq.cool.qqbot.myqq.request.AbstractMyQQRequest;
import com.linq.cool.qqbot.myqq.response.MyQQResponse;
import com.linq.cool.qqbot.myqq.utils.json.JsonUtils;
import com.linq.cool.qqbot.myqq.utils.MyQQHttpRequestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author: yqlin
 * @date: 2021/7/2 15:42
 * @description: MyQQ调用Api模板
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MyQQHttpRequestTemplate {
    private final MyQQProperties myQQProperties;
    private final Pattern pattern = Pattern.compile("^c[1-9]+$");

    public MyQQResponse doRequest(MyQQApiEnum apiEnum, Object... args) {
        return MyQQHttpRequestUtil.doRequest(apiEnum.getHttpMethod(), myQQProperties.getHost(), myQQProperties.getPort(), myQQProperties.getToken(), apiEnum.getApiFunctionName(), args);
    }

    public MyQQResponse doRequest(MyQQApiEnum apiEnum, Map<String, Object> argsMap) {
        return MyQQHttpRequestUtil.doRequest(apiEnum.getHttpMethod(), myQQProperties.getHost(), myQQProperties.getPort(), myQQProperties.getToken(), apiEnum.getApiFunctionName(), argsMap);
    }

    public MyQQResponse doRequest(Object obj, Class<? extends AbstractMyQQRequest> clazz) {
        if (obj == null) {
            return null;
        }
        if (!obj.getClass().equals(clazz)) {
            throw new UtilException(InternalUtilEnum.MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__TYPE_NOT_MATCH_ERROR);
        }
        Map<String, Object> argsMap = new HashMap<>(8);
        Map<String, Object> propertyMap = new HashMap<>(8);
        try {
            RequestEntity requestEntity = clazz.getAnnotation(RequestEntity.class);
            if (null == requestEntity) {
                throw new UtilException(InternalUtilEnum.MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__LACK_OF_ANNOTATION_REQUEST_ENTITY_ERROR);
            }
            composeRequestArgsMap(obj, argsMap, propertyMap, clazz);
            MyQQApiEnum myQQApiEnum = requestEntity.apiEnum();
            MyQQResponse myQQResponse = doRequest(myQQApiEnum, argsMap);
            log.info("\n\n返回Json数据: \n{}\n", JsonUtils.printJson(myQQResponse));
            return myQQResponse;
        } catch (Exception e) {
            log.error("封装请求参数失败: ", e);
        }
        return null;
    }

    private void composeRequestArgsMap(Object obj, Map<String, Object> argsMap, Map<String, Object> propertyMap, Class<?> clazz) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (!"class".equals(key)) {
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                propertyMap.put(key, value);
            }
        }
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            RequestArg requestArg = field.getAnnotation(RequestArg.class);
            if (null == requestArg) {
                throw new UtilException(InternalUtilEnum.MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__LACK_OF_ANNOTATION_REQUEST_ARG_ERROR);
            }
            String key = requestArg.key();
            Matcher matcher = pattern.matcher(key);
            if (!matcher.find()) {
                throw new UtilException(InternalUtilEnum.MY_QQ_HTTP_REQUEST_TEMPLATE__DO_REQUEST__LACK_OF_ANNOTATION_REQUEST_ARG_NOT_SATISFY_C_ARGS_ERROR);
            }
            argsMap.put(key, propertyMap.get(field.getName()));
        });
    }


    public static void main(String[] args) {
        //        MyQQApiSendMsgRequest request = new MyQQApiSendMsgRequest()
        //                .setRobotQQ("3377894260")
        //                .setInfoType(MyQQTypeEnum.MESSAGE_TYPE_FRIEND.getCode())
        //                .setTargetQQ("1781913075")
        //                .setContent("测试数据");
        //        System.out.println(JSON.toJSONString(request));
    }
}
