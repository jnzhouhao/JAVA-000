学习笔记



```
geek-starter是自定义starter实现，将其打成jar包并引入到geek项目中，在com.candy.geek.week05.starter.StarterTest测试类中测试；

--geek
  -- com.candy.geek.week05
    -- intBean   bean的多种装配方式
    -- jdbc      JDBC原生接口和数据库连接池
    -- starter   引入jar包，测试自定义studentStarter配置
      
		geek项目POM文件引入spring-boot-starter-student.jar
		<dependency>
            <groupId>com.candy.geek.student</groupId>
            <artifactId>spring-boot-starter-student</artifactId>
            <version>1.0.0</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/src/main/resources/lib/spring-boot-starter-student.jar</systemPath>
        </dependency>
```

