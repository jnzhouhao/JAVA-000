package com.candy.dynamicdatasource.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zh0809
 * @date 2020/12/2 10:58
 **/
@Data
@TableName("test_user")
public class UserDO implements Serializable {

    @TableId
    private Integer userId;

    private String userName;

}
