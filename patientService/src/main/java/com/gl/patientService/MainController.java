package com.gl.patientService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @GetMapping("/patients")
    public String patients(){
        return "List of patients";
    }

    @GetMapping("/location")
    public String getpatientsLocation(){
        return appName + " : " + port;
    }
}
