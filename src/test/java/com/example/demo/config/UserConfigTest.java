package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserConfigTest {

    @Autowired
    private UserConfig userConfig;
    @Test
    public void getUserConfig() {
        System.out.println(JSONObject.toJSONString(userConfig));
    }
}