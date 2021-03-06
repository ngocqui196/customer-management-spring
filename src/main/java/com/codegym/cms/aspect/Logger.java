package com.codegym.cms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterReturning(pointcut = "within(com.codegym.cms.controller.*)",returning = "result")
    public void log(JoinPoint joinPoint,Object result) {
        System.out.println("Start log");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "." + methodName);
        if(result == null){
            System.out.println("null");
        }
        else {
            System.out.println(result.hashCode());
        }
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.cms.service.impl.CustomerServiceImpl.*(..))")
    public void log() {
    }
}
