package org.ilmostro.businesss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusinessServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessServicesApplication.class, args);
    }

}
