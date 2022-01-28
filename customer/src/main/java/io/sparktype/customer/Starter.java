package io.sparktype.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Starter {

  public static void main(String[] args) {
    SpringApplication.run(Starter.class, args);
  }

}
