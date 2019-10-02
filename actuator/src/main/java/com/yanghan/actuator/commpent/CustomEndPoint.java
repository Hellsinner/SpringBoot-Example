package com.yanghan.actuator.commpent;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanghan on 2019-09-28.
 */
@Component
@Endpoint(id = "demo", enableByDefault = true)
public class CustomEndPoint {
    @ReadOperation
    public Map<String, String> demo() {
        Map<String, String> map = new HashMap<>();
        map.put("demo", "CustomEndPoint");
        return map;
    }

    @WriteOperation
    public Map<String, String> demo1() {
        Map<String, String> map = new HashMap<>();
        map.put("demo", "CustomEndPoint");
        return map;
    }
}
