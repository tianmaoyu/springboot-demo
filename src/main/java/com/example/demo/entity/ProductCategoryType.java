package com.example.demo.entity;

public enum ProductCategoryType {
    FREE(1,"free 免费"),
    VIP(2,"付费");

    private final Integer code;
    private final String desc;
    ProductCategoryType(Integer code, String desc){
        this.code=code;
        this.desc=desc;
    }
}
