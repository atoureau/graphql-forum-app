package com.bgeneral.graphql.forum.config;

import com.bgeneral.graphql.forum.config.instrumentation.LoggingInstrumentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import graphql.execution.instrumentation.Instrumentation;

@Configuration
public class GraphQLConfig {

    @Bean
    public Instrumentation instrumentation() {
        return new LoggingInstrumentation();
    }
}