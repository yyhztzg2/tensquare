package com.tensquare.article.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.tree.VoidDescriptor;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TEst {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void DSDSFSFS(){
        stringRedisTemplate.boundValueOps("liwei").set("hunanren", 555, TimeUnit.SECONDS);
    }

    @Test
    public void DSDSF1SFS(){
        People liwei = new People("liwei", 1);
        redisTemplate.opsForValue().set("1", liwei, 1515, TimeUnit.SECONDS);
    }

}

class People implements Serializable {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public People() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
