package cn.tedu.sp07;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class Sp07HystrixApplication {

    public static void main(String[] args) {

        SpringApplication.run(Sp07HystrixApplication.class, args);
    }



}
