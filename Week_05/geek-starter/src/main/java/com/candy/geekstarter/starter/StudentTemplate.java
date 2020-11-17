package com.candy.geekstarter.starter;

/**
 * @author zh0809
 * @date 2020/11/17 9:17
 **/
public class StudentTemplate {

    private int id;

    private String name;

    public String getName() {
        return "name is " + name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
