package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Aspect
@Component
public class HttpAspect {

    private final   static Logger  logger= LoggerFactory.getLogger(HttpAspect.class);
//    @Before("execution(public * com.example.demo.apicontroller.UserController.*(..))")
//    public void controllerActionBefore(){
//        System.out.println("******log******");
//    }
//
//    @After("execution(public * com.example.demo.apicontroller.UserController.*(..))")
//    public void controllerActionAfter(){
//        System.out.println("******log******");
//    }

    @Pointcut("execution(public * com.example.demo.apicontroller.UserController.*(..))")
    public void log(){ }


    @Before("log()")
    public  void  actionBefor(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("method={}",request.getRemoteAddr());
        logger.info("controller action={}", joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
        for (Object obj:joinPoint.getArgs()){
            if(obj instanceof org.springframework.validation.BeanPropertyBindingResult){
              continue;
            }
            if(obj instanceof  Serializable){
                logger.info("action args={}", JSONObject.toJSONString(obj));
            }
        }
    }
    @After("log()")
    public  void  actionAfter(){
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public  void  actionReturn(Object object){
          logger.info("return={}",JSONObject.toJSONString(object));
    }
}
