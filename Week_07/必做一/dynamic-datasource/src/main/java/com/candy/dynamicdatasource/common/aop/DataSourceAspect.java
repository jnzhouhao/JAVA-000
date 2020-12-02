package com.candy.dynamicdatasource.common.aop;

import com.candy.dynamicdatasource.common.DataSourceContextHolder;
import com.candy.dynamicdatasource.common.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zh0809
 * @date 2020/12/2 11:13
 **/
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@annotation(com.candy.dynamicdatasource.common.annotation.DataSource)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object beforeSwitchDs(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(DataSource.class)) {
            String targetDataSource = targetMethod.getAnnotation(DataSource.class).value().getValue();
            DataSourceContextHolder.setDataSource(targetDataSource);
        }
        // 执行方法
        Object result = pjp.proceed();
        DataSourceContextHolder.clear();
        return result;
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }

}
