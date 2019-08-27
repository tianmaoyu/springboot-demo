package com.example.demo.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Log {
    private final Logger logger = LoggerFactory.getLogger(Log.class);
    @Test
    public void log() {
        logger.info("***********");
        String name="eric";
        int age=18;
        logger.info("name:{},age:{}",name,age);

        logger.error("name:{},age:{}",name,age);
    }

}
