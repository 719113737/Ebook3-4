package com.example.collect_service.mapper;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient("BOOK-SERVICE")
public interface BookFeignClient {

    @GetMapping("/books/{title}")
    Map findById(@PathVariable("title") String id);
}
