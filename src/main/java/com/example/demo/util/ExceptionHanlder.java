package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHanlder {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHanlder.class);

//    /**
//     * 方式一
//     * @param ex
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public final Result<Boolean> hanlder(Exception ex) {
//        Result<Boolean> result=new Result<>();
//        logger.info("error={}",ex);
//
//        if(ex instanceof  CommonException){
//            result.setCode(3);
//            result.setMsg(ex.getMessage());
//            return  result;
//        }
//        result.setCode(4);
//        result.setMsg("未知错误");
//        return  result;
//    }


//    /**
//     * 方式一
//     * @param ex
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public final Result<Boolean> hanlder(Exception ex,WebRequest request, HttpServletRequest httpRequest) {
//        Result<Boolean> result=new Result<>();
//        logger.info("error={}",ex);
//
//        if(ex instanceof  CommonException){
//            result.setCode(3);
//            result.setMsg(ex.getMessage());
//            return  result;
//        }
//        result.setCode(4);
//        result.setMsg("未知错误");
//        return  result;
//    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public final Result<Boolean> hanlder(Exception ex, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        Result<Boolean> result=new Result<>();
        logger.info("error={}",ex);
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("method={}",request.getRemoteAddr());
        if(ex instanceof  CommonException){
            result.setCode(3);
            result.setMsg(ex.getMessage());
            return  result;
        }
        result.setCode(4);
        result.setMsg("未知错误");
        return  result;
    }

//    /**
//     * 返回一个页面
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = Exception.class)
//    Object handleMyException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index.html");
//        modelAndView.addObject("msg", e.getMessage());
//        return modelAndView;
//    }
}
