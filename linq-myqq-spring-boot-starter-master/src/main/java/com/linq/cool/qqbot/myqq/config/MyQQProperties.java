package com.linq.cool.qqbot.myqq.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yqlin
 * @date: 2021/7/2 9:35
 * @description:
 */
@Data
@Accessors(chain = true)
@Configuration
@ConfigurationProperties(prefix = "myqq")
public class MyQQProperties {
    private String host;
    private String port;
    private String token;
}
