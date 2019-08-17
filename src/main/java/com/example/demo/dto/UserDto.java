package com.example.demo.dto;

import com.example.demo.util.Odd;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 3456789038421L;

    @NotEmpty(message = "不能为空")
    private  String name;
    @Min(value = 12,message = "不能小于12岁")
    private  Integer age;

    @Odd(message = "必须为奇数")
    private  Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
