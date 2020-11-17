package com.candy.geek.week05.starter;

import com.candy.geekstarter.starter.StudentTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zh0809
 * @date 2020/11/17 10:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterTest {

    @Autowired
    private StudentTemplate studentTemplate;

    @Test
    public void testStudentStarter() {
        System.out.println(studentTemplate.getId() + " : " + studentTemplate.getName());
    }

}
