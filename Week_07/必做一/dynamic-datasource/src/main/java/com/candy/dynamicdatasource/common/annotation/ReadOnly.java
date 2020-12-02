package com.candy.dynamicdatasource.common.annotation;

import com.candy.dynamicdatasource.common.enums.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zh0809
 * @date 2020/12/2 14:07
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnly {

    DataSourceEnum[] value() default {DataSourceEnum.SLAVE, DataSourceEnum.SLAVE2, DataSourceEnum.SLAVE3};

}
