package com.ypk.common.config;

import com.ypk.app.R;
import com.ypk.common.ExceptionCodeEunm;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestControllerAdvice  给所有的方法添加ResponseBody
 * 类中所有的方法的返回值都会被以json数据返回
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * BindException参数校验异常
     * @param be
     * @return
     */
    @ExceptionHandler(BindException.class)
    public R getBindException(BindException be){
        BindingResult result = be.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        Map map=new HashMap();
        for (FieldError error : errors) {
            map.put(error.getField(),error.getDefaultMessage());
        }
        return R.error(ExceptionCodeEunm.VALID_FAIL.getCode(),ExceptionCodeEunm.VALID_FAIL.getMsg()).put("data",map);
    }
}
