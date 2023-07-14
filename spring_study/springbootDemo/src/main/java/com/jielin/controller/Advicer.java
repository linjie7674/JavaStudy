package com.jielin.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;

@Component
@Aspect
public class Advicer {

    @Autowired
    private HttpServletRequest request;
    private long timeBegin, timeEnd;

    @Before("within(com.jielin.controller..*)")
    public void before(){
        timeBegin = System.currentTimeMillis();
        System.out.printf("server name: %s, port: %s\n", request.getServerName(), request.getServerPort());
    }

    @After("within(com.jielin.controller..*)")
    public void after(JoinPoint joinPoint){
        timeEnd = System.currentTimeMillis();
        System.out.printf("method %s takes %s ms\n", joinPoint.getSignature().getName(), (timeEnd - timeBegin));
    }
}
