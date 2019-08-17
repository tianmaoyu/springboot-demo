package com.example.demo.controller;

import com.example.demo.entity.Luckymoney;
import com.example.demo.repository.LuckmoneyRepository;
import com.example.demo.service.LuckmoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("luckymoney/")
public class LuckymoneyController {


    @Autowired
    private LuckmoneyRepository repository;


    @Autowired
    private LuckmoneyService service;


    @RequestMapping("create")
    public Luckymoney create(){
        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setMoney(BigDecimal.valueOf(100));
        luckymoney.setConsumer("你好好");
        luckymoney.setProduce("root");
        Luckymoney info = repository.save(luckymoney);
        return  info;
    }

    @RequestMapping("update")
    public Luckymoney update(){
        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setId(1);
        luckymoney.setMoney(BigDecimal.valueOf(100));
        luckymoney.setConsumer("你好好");
        luckymoney.setProduce("root");
        Luckymoney info = repository.save(luckymoney);
        return  info;
    }



    @RequestMapping("updateTwo")
    public void updateTwo(){
        boolean b = service.upateTwo();
    }

  @GetMapping("getInfo/{id}")
    public Luckymoney getInfo(@PathVariable("id") Integer id){
      Luckymoney luckymoney = this.repository.findById(id).orElse(null);
      return luckymoney;
    }

    @RequestMapping("getAll")
    public List<Luckymoney> getAll(){
        List<Luckymoney> luckymoneyList = repository.findAll();
        return luckymoneyList;
    }

}
