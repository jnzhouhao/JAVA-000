package com.candy.geekstarter.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zh0809
 * @date 2020/11/17 9:08
 **/
@Configuration
@EnableConfigurationProperties(StudentServiceProperties.class)
@ConditionalOnClass(StudentAutoConfiguration.class)
@ConditionalOnProperty(prefix = "com.candy.student", value = "enabled", matchIfMissing = true)
public class StudentAutoConfiguration {

    @Autowired
    private StudentServiceProperties studentServiceProperties;

    @Bean
    @ConditionalOnMissingBean(StudentTemplate.class)
    public StudentTemplate studentTemplate() {
        StudentTemplate template = new StudentTemplate();
        template.setId(studentServiceProperties.getId());
        template.setName(studentServiceProperties.getName());
        return template;
    }

}
