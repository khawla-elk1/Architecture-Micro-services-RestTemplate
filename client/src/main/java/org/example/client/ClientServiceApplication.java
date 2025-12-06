package org.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 1. Remove the incorrect imports: com.netflix.discovery.EurekaNamespace and org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient
// 2. Import the correct, generic Service Discovery annotation
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Correct annotation to activate service registration
public class ClientServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
}