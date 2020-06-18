package com.example.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Autowired(required = false)
    private FeignClientService feignClientService;



    @HystrixCommand(fallbackMethod = "executeHystrixHandle")
    @RequestMapping("/api/test/get")
    public String consumer(){

        return feignClientService.consumer();
    }


    public String executeHystrixHandle() {
        return  "Too many requests.";

    }


}

