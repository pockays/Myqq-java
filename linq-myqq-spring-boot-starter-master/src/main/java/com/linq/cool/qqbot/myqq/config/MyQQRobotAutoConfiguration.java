package com.linq.cool.qqbot.myqq.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yqlin
 * @date 2021/8/6 23:10
 * @description
 */
@Configuration
@ComponentScan(basePackages = {"com.linq.cool.qqbot.myqq"})
@EnableConfigurationProperties({MyQQProperties.class})
public class MyQQRobotAutoConfiguration {
}
