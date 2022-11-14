package com.stevedev.configuration;

import com.stevedev.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = "com.stevedev.configuration")
public class ApplicationConfiguration {

    @Autowired
    AppSecrets appSecrets;

    @Bean
    public MyService myService() {
        return new MyService(appSecrets);
    }
}
