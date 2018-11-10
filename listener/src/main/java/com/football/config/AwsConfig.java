package com.football.config;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.football.service.FootballService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    private final static String regionName = "us-east-1";

    @Bean
    public AWSLambda builder() {
        return AWSLambdaClientBuilder.standard()
                .withRegion(regionName)
                .build();
    }

    @Bean
    public FootballService incomeRegisterService() {
        return LambdaInvokerFactory.builder()
                .lambdaClient(builder())
                .build(FootballService.class);
    }
}

