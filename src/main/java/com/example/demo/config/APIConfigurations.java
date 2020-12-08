package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class APIConfigurations {

    /**
     *  these vars will be set as environment variables by our SealedSecrets. Those will be mounted at a specific location in a
     *  pod. Then we pick that properties file from that specific location and read it to set environment variables.
     *
     */
    @Value("$(username:#{null})")
    private String username;
    @Value("$(password:#{null})")
    private String password;

    @Bean
    public void setAPIConfigurations() {
        // pass credentials / sensitive data for different tasks
        doAnyDemoTaskWithCredentials(username, password);
    }
}
