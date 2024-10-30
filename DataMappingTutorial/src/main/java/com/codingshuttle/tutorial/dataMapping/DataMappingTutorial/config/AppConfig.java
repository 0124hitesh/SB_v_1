package com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.config;

import com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.auth.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl")
public class AppConfig {

    @Bean
    AuditorAware<String> getAuditorAwareImpl() {
            return new AuditorAwareImpl();
    }
}
