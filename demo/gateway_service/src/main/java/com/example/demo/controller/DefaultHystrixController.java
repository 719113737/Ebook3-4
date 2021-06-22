package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultHystrixController {

  //  @RequestMapping("/defaultfallback")
    public String defaultfallback(){
        System.out.println("降级");

        return "{code:200,msg:\"服务异常\"}";
    }

    /**
     * 超时测试
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultfallback")
    @RequestMapping("/timeout")
    public String timeout() {
        try{
            Thread.sleep(10000);
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "return after timeout";
    }
}
