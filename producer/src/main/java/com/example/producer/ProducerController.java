package com.example.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @RequestMapping("/producer/return")
    public String produce(){
        return "Succeed";
    }
}
