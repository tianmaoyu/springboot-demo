package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
    private RedisTemplate redisTemplate;

//    private ValueOperations<String,Object> valueOperations;
//
//    private HashOperations<String, String, Object> hashOperations;
//
//    private ListOperations<String, Object> listOperations;
//
//    private SetOperations<String, Object> setOperations;
//
//    private ZSetOperations<String, Object> zSetOperations;


    @Test
    public void testValueOption( )throws  Exception{
        UserDto dto = new UserDto();
        dto.setLevel(10);
        dto.setName("jantent");
        dto.setAge(23);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test",JSONObject.toJSONString(dto));

        System.out.println( valueOperations.get("test"));
    }

    @Test
    public void testSetOperation() throws Exception{
        UserDto dto = new UserDto();
        dto.setLevel(10);
        dto.setName("jantent");
        dto.setAge(23);
        UserDto auserVo = new UserDto();
        dto.setLevel(10);
        auserVo.setName("antent");
        auserVo.setAge(23);
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("user:test",dto,auserVo);
        Set<Object> result = setOperations.members("user:test");
        System.out.println(result);
    }

    @Test
    public void HashOperations() throws Exception{
        UserDto dto = new UserDto();
        dto.setLevel(10);
        dto.setName("jantent");
        dto.setAge(23);
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("hash:user",dto.hashCode()+"",dto);
        System.out.println(hashOperations.get("hash:user",dto.hashCode()+""));
    }

    @Test
    public void  ListOperations() throws Exception{
        UserDto dto = new UserDto();
        dto.setLevel(10);
        dto.setName("jantent");
        dto.setAge(23);
        ListOperations listOperations = redisTemplate.opsForList();
        System.out.println(listOperations.leftPop("list:user"));
    }

}
