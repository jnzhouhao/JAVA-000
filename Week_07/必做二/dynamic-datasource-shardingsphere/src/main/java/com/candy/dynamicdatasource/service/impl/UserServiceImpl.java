package com.candy.dynamicdatasource.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.candy.dynamicdatasource.dao.UserDao;
import com.candy.dynamicdatasource.entity.UserDO;
import com.candy.dynamicdatasource.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zh0809
 * @date 2020/12/2 11:01
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {

    @Override
    public UserDO findById(int id) {
        return selectById(id);
    }

    @Override
    public List<UserDO> findAll() {
        return selectList(null);
    }
}
