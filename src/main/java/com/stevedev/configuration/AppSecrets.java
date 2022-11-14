package com.stevedev.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

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
        final StringBuilder sb = new StringBuilder("AppSecrets{");
        sb.append("apiKey='").append(apiKey).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
