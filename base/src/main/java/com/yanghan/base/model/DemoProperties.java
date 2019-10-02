package com.yanghan.base.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by yanghan on 2019-09-25.
 */
@Component
@ConfigurationProperties(prefix = "book")
@Data
public class DemoProperties {

    public String author;

    public int age;
}
