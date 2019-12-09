package org.com.marcosdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.com.marcosdemo")
public class MarcosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarcosDemoApplication.class, args);
    }

}
