package com.example.demo.service;

import com.example.demo.entity.Luckymoney;
import com.example.demo.repository.LuckmoneyRepository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckmoneyService {

    @Autowired
    private LuckmoneyRepository repository;

    @Transactional
    public boolean upateTwo(){
        boolean result=false;
        try {
            Luckymoney luckymoney1=new Luckymoney();
            luckymoney1.setId(3);
            luckymoney1.setConsumer("2");
            luckymoney1.setProduce("2");
            luckymoney1.setMoney(BigDecimal.valueOf(50));
            repository.save(luckymoney1);
            Luckymoney luckymoney2=new Luckymoney();
            luckymoney2.setId(4);
            luckymoney2.setConsumer("2");
            luckymoney2.setMoney(BigDecimal.valueOf(150));
            luckymoney2.setProduce("2");
            repository.save(luckymoney2);
            result=true;
        }catch (Exception ex){

        }
        return result;
    }

}
