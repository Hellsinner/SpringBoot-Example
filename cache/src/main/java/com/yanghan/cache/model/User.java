package com.yanghan.cache.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yanghan on 2019-09-28.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 9083728868837488368L;
    private String name;

    private int age;
}
