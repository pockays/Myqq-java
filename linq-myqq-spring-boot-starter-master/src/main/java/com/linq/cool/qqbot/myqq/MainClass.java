package com.linq.cool.qqbot.myqq;


import com.linq.cool.qqbot.myqq.factory.MyQQRobotCallbackHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuris
 * @create 2024-04-17-19:18
 */
@SpringBootApplication
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class,args);
    }
}
