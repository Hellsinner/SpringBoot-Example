package com.yanghan.actuator.commpent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanghan on 2019-10-02.
 */
@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class ExtendEndPoint {
    @Autowired
    private InfoEndpoint infoEndpoint;

    @ReadOperation
    public Map<String, Object> demo() {
        Map<String, Object> info = infoEndpoint.info();
        Map<String, Object> map = new HashMap<>();
        map.put("info", info);
        map.put("demo", "ExtendEndPoint");
        return map;
    }
}
