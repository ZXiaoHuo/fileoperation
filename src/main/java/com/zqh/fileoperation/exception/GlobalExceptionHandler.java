package com.zqh.fileoperation.exception;

import com.google.zxing.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangqh
 * @date 2021/9/7 0007 16:10
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = com.google.zxing.NotFoundException.class)
    public String notFound(NotFoundException e){

        return "解析错误";
    }

}
