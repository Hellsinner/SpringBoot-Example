package com.yanghan.web.commpent;

import com.yanghan.web.model.DemoException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by yanghan on 2019-10-01.
 */
@RestControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(value = {DemoException.class})
    public String hanlder(DemoException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(value = Throwable.class)
    public String handler() {
        return "server failed";
    }
}
