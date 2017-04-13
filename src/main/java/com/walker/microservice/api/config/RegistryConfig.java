package com.walker.microservice.api.config;

import com.walker.microservice.framework.registry.ServiceRegistry;
import com.walker.microservice.framework.registry.impl.ServiceRegistryImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by walker on 2017/4/13.
 */
@Configuration
@ConfigurationProperties(prefix = "registry")
public class RegistryConfig {
    private String servers;

    public void setServers(String servers) {
        this.servers = servers;
    }

    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistryImpl(servers);
    }
}
