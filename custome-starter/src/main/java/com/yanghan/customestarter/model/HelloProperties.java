package com.yanghan.customestarter.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yanghan on 2019-09-26.
 */
@ConfigurationProperties(prefix = "hello")
@Data
public class HelloProperties {
    private String msg = "world";
}
