### 必做作业一：读写分离-动态切换数据源版本1.0

1、通过自定义注解 @DataSource来指定本次数据操作使用的数据源，默认是master，并在业务实现类的方法上使用该注解来指定数据源

```
-- 自定义注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.MASTER;

}

-- 在DataSourceAspect类中拿到@DataSource注解，并切换到指定的数据源中

-- 在业务实现类中的方法上添加注解@DataSource，并指定对应的数据源名称，例如：findAll()
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {

    @Override
    @DataSource(value = DataSourceEnum.SLAVE3)
    public List<UserDO> findAll() {
        return selectList(null)
    }
    
}

```

2、新增自定义注解：@ReadOnly 来指定操作哪些从库并通过加权轮询来支持多个从库的负载均衡，默认读所有从库

```
// 2.1 自定义注解：ReadOnly.java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnly {

    DataSourceEnum[] value() default {DataSourceEnum.SLAVE, DataSourceEnum.SLAVE2, DataSourceEnum.SLAVE3};

}

// 2.2 在ReadOnlyAspect类中拿到@ReadOnly注解拿到要操作的从库数组，利用加权轮询算法来获取其中某个数据源并切换至该数据源上

// 2.3 业务实现类的方法上使用ReadOnly
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {

    @Override
    @ReadOnly(value = {DataSourceEnum.SLAVE, DataSourceEnum.SLAVE2})
    public UserDO findById(int id) {
        return selectById(id);
    }
    
}



```

