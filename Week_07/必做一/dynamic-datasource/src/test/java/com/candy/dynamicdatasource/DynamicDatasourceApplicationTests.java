package com.candy.dynamicdatasource;

import com.alibaba.fastjson.JSONObject;
import com.candy.dynamicdatasource.entity.UserDO;
import com.candy.dynamicdatasource.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicDatasourceApplicationTests {

    @Autowired
    UserService userService;

    //@Test
    void contextLoads() {
    }

    @Test
    void test() {
        UserDO user = userService.findById(1);
        System.out.println(JSONObject.toJSONString(user));
    }

}
