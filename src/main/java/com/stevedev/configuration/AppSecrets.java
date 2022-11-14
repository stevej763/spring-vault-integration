package com.stevedev.configuration;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

@ConfigurationProperties(prefix = "vault")
@ConstructorBinding
public class AppSecrets {

    private final String apiKey;
    private final String username;
    private final String password;
    private final String uuid;

    public AppSecrets(String apiKey, String username, String password, String uuid) {
        this.apiKey = apiKey;
        this.username = username;
        this.password = password;
        this.uuid = uuid;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, MULTI_LINE_STYLE);
    }
}
