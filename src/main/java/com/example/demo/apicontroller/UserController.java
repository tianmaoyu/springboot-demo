package com.example.demo.apicontroller;

import com.example.demo.config.Config;
import com.example.demo.config.UserConfig;
import com.example.demo.dto.UserDto;
import com.example.demo.util.CommonException;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user/")
public class UserController {

//    @Value("${host}")
//    private String host;
//
//    @Value("${hostname}")
//    private String hostname;

   @Autowired
   private Config config;
    @Autowired
   private UserConfig userConfig;

    @RequestMapping("getUser")
    public Result<UserDto>  getUser(){
        Result<UserDto> result=new Result<>();

        UserDto dto =new UserDto();
        dto.setName("eric");
        dto.setAge(18);

        result.setCode(0);
        result.setData(dto);
        return result;
    }

    @RequestMapping("getConfig")
    public  String getConfig(){
        return  config.getHost()+config.getAge();
    }

    @RequestMapping("userConfig")
    public  UserConfig userConfig(){
        return  userConfig;
    }

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public   Result<UserDto> addUser(@Valid UserDto user, BindingResult bindingResult){

        Result<UserDto> result=new Result<>();
        if(true){
            throw new CommonException("自定义一个异常");
        }

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        result.setCode(0);
        result.setData(user);
        return  result;
    }
}
