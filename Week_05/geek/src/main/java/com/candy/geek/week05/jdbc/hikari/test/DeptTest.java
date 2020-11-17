package com.candy.geek.week05.jdbc.hikari.test;

import com.candy.geek.week05.jdbc.hikari.entity.SysDept;
import com.candy.geek.week05.jdbc.hikari.repository.DeptRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author zh0809
 * @date 2020/11/17 8:38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptTest {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void testGetById() {
        Optional<SysDept> deptOptional = deptRepository.findById("03ef2966d4aa4aab91f9997a9ea7b71a");
        if(deptOptional.isPresent()) {
            SysDept dept = deptOptional.get();
            System.out.println(dept.getDeptId() + "：" + dept.getName());
        }
    }

}
