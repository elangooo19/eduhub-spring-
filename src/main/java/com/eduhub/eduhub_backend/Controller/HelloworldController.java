package com.eduhub.eduhub_backend.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloworldController {

    private final Environment environment;

    @Value("${spring.application.name}")
    private String appName;

    public HelloworldController(Environment environment){
        this.environment = environment;
    }

    @GetMapping("hello-world")
    public String helloworld(){
        return "HelloWorld";
    }

    @GetMapping("/env")
            public String getEnvironmentVariable(){
        String port = environment.getProperty("server.port");
        return "App Name:" + appName + "Port:" +port;
    }
}
