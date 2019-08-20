package com.example.demo.pojo;

import java.math.BigDecimal;
import javax.persistence.*;

public class Luckymoney {
    @Id
    private Integer id;

    private String consumer;

    private BigDecimal money;

    private String produce;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return consumer
     */
    public String getConsumer() {
        return consumer;
    }

    /**
     * @param consumer
     */
    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    /**
     * @return money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * @return produce
     */
    public String getProduce() {
        return produce;
    }

    /**
     * @param produce
     */
    public void setProduce(String produce) {
        this.produce = produce;
    }
}