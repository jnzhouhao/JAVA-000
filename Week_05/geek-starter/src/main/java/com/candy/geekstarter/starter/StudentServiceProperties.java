package com.candy.geekstarter.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zh0809
 * @date 2020/11/17 9:04
 **/
@ConfigurationProperties(prefix = "com.candy.student")
public class StudentServiceProperties {

    private int id = 100;

    private String name = "candy";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
