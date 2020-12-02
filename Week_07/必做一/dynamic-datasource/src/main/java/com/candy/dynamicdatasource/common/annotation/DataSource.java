package com.candy.dynamicdatasource.common.annotation;

import com.candy.dynamicdatasource.common.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @author zh0809
 * @date 2020/12/2 11:12
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.MASTER;

}
