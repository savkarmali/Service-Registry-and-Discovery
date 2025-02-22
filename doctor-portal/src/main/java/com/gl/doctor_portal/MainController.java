package com.gl.doctor_portal;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/doctors")
    public String getDoctors(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("doctor-service", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseUrl + "/location", String.class);
    }

    @GetMapping("/diseases")
    public String getDiseases(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("disease-SERVICE", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();//http://localhost:port
        return restTemplate.getForObject(baseUrl+"/location", String.class);

    }
    @GetMapping("/patients")
    public String getPatients(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("patients-SERVICE", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();//http://localhost:port
        return restTemplate.getForObject(baseUrl+"/location", String.class);

    }
}
