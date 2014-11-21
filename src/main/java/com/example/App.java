package com.example;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App {

    @Component
    static class JerseryConfig extends ResourceConfig {
        public JerseryConfig() {
            packages(true, "com.example")
                    .register(MessagePackObjectMapperResolver.class)
                    .register(JacksonFeature.class);
            ;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}