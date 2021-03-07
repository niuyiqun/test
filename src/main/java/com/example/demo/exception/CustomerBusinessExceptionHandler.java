package com.example.demo.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
/**
 * 自定义业务处理业务异常类
 */
@ControllerAdvice         //实现控制器通知，默认对所有的控制器生效
public class CustomerBusinessExceptionHandler {
    @ResponseBody
    @ExceptionHandler(BusinessException.class)     //定义控制器异常后的操作，可以拦截所有控制器发生的异常
    public Map<String, Object> businessExceptionHandler(BusinessException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", e.getCode());
        map.put("message", e.getMessage());
        //发生异常进行日志记录，此处省略
        return map;
    }
}