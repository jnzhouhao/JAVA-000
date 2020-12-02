package com.candy.dynamicdatasource.common.aop;

import com.candy.dynamicdatasource.common.DataSourceContextHolder;
import com.candy.dynamicdatasource.common.annotation.ReadOnly;
import com.candy.dynamicdatasource.common.enums.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author zh0809
 * @date 2020/12/2 14:09
 **/
@Component
@Slf4j
@Aspect
@Order(-10)
public class ReadOnlyAspect {

    private Integer pos = 0;

    @Pointcut("@annotation(com.candy.dynamicdatasource.common.annotation.ReadOnly)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object beforeReadOnly(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(ReadOnly.class)) {
            // 获取只读数据源数组
            DataSourceEnum[] dataSourceEnums = targetMethod.getAnnotation(ReadOnly.class).value();
            // 通过负载均衡算法获取db
            Map<String, Integer> map = Arrays.stream(dataSourceEnums).collect(Collectors.toMap(DataSourceEnum::getValue, DataSourceEnum::getWeight));
            String targetDataSource = weightRobin(map);
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

    /**
     * 加权轮询 负载平衡算法
     */
    private String weightRobin(Map<String, Integer> ipMap){
        Map<String, Integer> ipServerMap = new ConcurrentHashMap<>(ipMap);
        Set<String> ipSet = ipServerMap.keySet();
        Iterator<String> ipIterator = ipSet.iterator();

        //定义一个list放所有server
        List<String> ipArrayList = new ArrayList<>();

        //循环set，根据set中的可以去得知map中的value，给list中添加对应数字的server数量
        while (ipIterator.hasNext()){
            String serverName = ipIterator.next();
            Integer weight = ipServerMap.get(serverName);
            for (int i = 0; i < weight; i++){
                ipArrayList.add(serverName);
            }
        }
        String serverName;
        if (pos >= ipArrayList.size()){
            pos = 0;
        }
        serverName = ipArrayList.get(pos);
        //轮询+1
        pos++;

        return serverName;
    }

}
