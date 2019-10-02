package com.yanghan.customestarter.service;

import lombok.Data;

/**
 * Created by yanghan on 2019-09-26.
 */
@Data
public class HelloService {
    private String msg;

    public void hello() {
        System.out.println("hello " + msg);
    }
}
