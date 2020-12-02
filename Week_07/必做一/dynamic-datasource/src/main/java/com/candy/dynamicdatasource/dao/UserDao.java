package com.candy.dynamicdatasource.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.candy.dynamicdatasource.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zh0809
 * @date 2020/12/2 11:00
 **/
@Mapper
public interface UserDao extends BaseMapper<UserDO> {
}
