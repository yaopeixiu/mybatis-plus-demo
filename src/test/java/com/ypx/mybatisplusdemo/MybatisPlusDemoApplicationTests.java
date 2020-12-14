package com.ypx.mybatisplusdemo;

import com.google.common.collect.ImmutableMap;
import com.ypx.mybatisplusdemo.constant.MongoConstant;
import com.ypx.mybatisplusdemo.entity.User;
import com.ypx.mybatisplusdemo.entity.mongo.Testdb;
import com.ypx.mybatisplusdemo.service.SimpleMongoService;
import com.ypx.mybatisplusdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//让测试运行于Spring测试环境，以便在测试开始的时候自动创建Spring的应用上下文；@RunWith是Junit的一个注解，就是一个运行器
@RunWith(SpringRunner.class)
//指定SpringBoot应用程序的入口
@SpringBootTest(classes = MybatisPlusDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserService userService;

    /**
     * lambda修改
     */
    @Test
    void lambdaUpdate() {
        Boolean update = userService.lambdaUpdate().eq(User::getGender, 1).set(User::getGender, 0).update();
        System.out.println(update);
    }

    /**
     * lambda查询
     */
    @Test
    public void lambdaQuery(){
        List<User> list = userService.lambdaQuery().eq(User::getAge, 24).list();
        list.forEach(System.out::println);
    }

    /**
     * lambda删除
     */
    @Test
    public void lambdaRemoce(){
        boolean remove = userService.lambdaUpdate().eq(User::getAge, 18).remove();
        System.out.println(remove);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("test:set1", "testValue1");
        redisTemplate.opsForSet().add("test:set2", "asdf");
        redisTemplate.opsForHash().put("hash1", "name1", "lms1");
        redisTemplate.opsForHash().put("hash1", "name2", "lms2");
        redisTemplate.opsForHash().put("hash1", "name3", "lms3");
        System.out.println(redisTemplate.opsForValue().get("test:set1"));
        System.out.println(redisTemplate.opsForHash().get("hash1", "name1"));
    }

    @Autowired
    private SimpleMongoService mongoService;

    @Test
    public void test1(){
        List<Testdb> testdbList = mongoService.selectByCondition(MongoConstant.Testdb, ImmutableMap.of("age", 23), Testdb.class, 1, 10, Sort.by(Sort.Order.asc("age")));
        System.out.println(testdbList);
    }

}
