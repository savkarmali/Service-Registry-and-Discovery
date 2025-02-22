package com.gl.doctor_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DoctorPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPortalApplication.class, args);
	}

}
