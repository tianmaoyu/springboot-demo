package com.example.demo.util;

/*spring 中只会对 runtimeException 进行事务回滚*/

public class CommonException extends  RuntimeException {

   public CommonException(String msg){
       super(msg);
   }

}
