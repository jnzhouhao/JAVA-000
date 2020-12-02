package com.candy.dynamicdatasource.service;

import com.baomidou.mybatisplus.service.IService;
import com.candy.dynamicdatasource.entity.UserDO;

import java.util.List;

/**
 * @author zh0809
 * @date 2020/12/2 11:00
 **/
public interface UserService extends IService<UserDO> {

    UserDO findById(int id);

    List<UserDO> findAll();
}
