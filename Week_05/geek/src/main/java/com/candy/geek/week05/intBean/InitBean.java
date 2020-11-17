package com.candy.geek.week05.intBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 第九课 作业2
 * spring bean的装配方式
 *
 * @author zh0809
 * @date 2020/11/16 16:39
 **/
@Configuration
public class InitBean {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // #1 通过@Component自动装配
        Student01 student01 = context.getBean(Student01.class);
        student01.sayHello();

        // #2 通过xml配置文件装配
        Student02 student02 = context.getBean(Student02.class);
        System.out.println("xml配置属性：id="+student02.getId() + ", name=" + student02.getName());
        student02.sayHello();

        // #3 通过@Configuration + @Bean搭配完成
        Student03 student03 = context.getBean(Student03.class);
        student03.sayHello();

    }

    @Bean
    public Student03 student03() {
        return new Student03();
    }

}
