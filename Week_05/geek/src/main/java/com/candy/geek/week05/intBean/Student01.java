package com.candy.geek.week05.intBean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author zh0809
 * @date 2020/11/16 16:24
 **/
@Data
@Component
public class Student01 {

    private Integer id;

    private String name;

    public void sayHello() {
        System.out.println("hello, student01, 自动装配方式~~~");
    }

}
