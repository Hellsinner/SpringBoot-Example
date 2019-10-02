package com.yanghan.base.service.impl;

import com.yanghan.base.service.Animal;
import org.springframework.stereotype.Service;

/**
 * Created by yanghan on 2019-09-30.
 */
@Service
public class Cat implements Animal {
    @Override
    public void say() {
        System.out.println("猫");
    }
}
