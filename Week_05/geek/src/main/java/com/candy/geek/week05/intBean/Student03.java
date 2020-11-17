package com.candy.geek.week05.intBean;

import lombok.Data;

/**
 * @author zh0809
 * @date 2020/11/16 16:24
 **/
@Data
public class Student03 {

    private Integer id;

    private String name;

    public void sayHello() {
        System.out.println("hello, student03, @Configuration + @Bean 配置方式~~~");
    }

}
