package com.candy.geek.week05.jdbc.hikari.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zh0809
 * @date 2020/11/16 17:35
 **/
@Data
@Entity
@Table(name = "sys_dept")
public class SysDept {

    @Id
    private String deptId;

    private String parentId;

    private String name;

    private String code;

    private Integer orderNum;

}
