package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InternalClientConfiguration {

  @Value("${internalclient.timeout.connect}")
  private int connectTimeout;

  @Value("${internalclient.timeout.read}")
  private int readTimeout;

  @LoadBalanced
  @Bean
  RestTemplate clientRestTemplate() {
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setConnectTimeout(connectTimeout);
    requestFactory.setReadTimeout(readTimeout);
    return new RestTemplate(requestFactory);
  }

}
