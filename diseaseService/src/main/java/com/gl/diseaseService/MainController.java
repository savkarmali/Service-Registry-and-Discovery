package com.gl.diseaseService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @GetMapping("/diseases")
    public String desease(){
        return "List of diseases";
    }

    @GetMapping("/location")
    public String getDoctorServiceLocation(){
        return appName + ":" + port;
    }
}
