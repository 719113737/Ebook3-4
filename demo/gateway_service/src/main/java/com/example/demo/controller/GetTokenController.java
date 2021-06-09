package com.example.demo.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GetTokenController {

    //todo 登录先访问该接口
    //todo 带上返回的token访问 http://localhost:8180/auth/realms/product_service/protocol/openid-connect/userinfo
    //todo 从而获得preferred_username作为该用户id
    @GetMapping("/greeting")
    public Map greeting(@RegisteredOAuth2AuthorizedClient("spring-gateway") OAuth2AuthorizedClient client) {
        Map<String, String> result = new HashMap<>();
        //result.put("username", oidcUser.getName());
        result.put("accessToken",client.getAccessToken().getTokenValue());

        return result;
    }
}
