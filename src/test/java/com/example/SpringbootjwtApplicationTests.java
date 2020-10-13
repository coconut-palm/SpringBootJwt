package com.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.awt.SunHints;

import java.util.Calendar;
import java.util.HashMap;


class SpringbootjwtApplicationTests {

    @Test
    void contextLoads() {
        //获取令牌
        HashMap<String, Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,600);

        String token = JWT.create()
                .withHeader(map) //header
                .withClaim("userId", "12") //payload
                .withClaim("username", "xiaohei")
                .withExpiresAt(instance.getTime()) //指定令牌过期时间
                .sign(Algorithm.HMAC256("XDFGH")); //签名

        System.out.println(token);

    }

    @Test
    public void test(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("XDFGH")).build();

        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDI1NTcyNzksInVzZXJJZCI6IjIxIiwidXNlcm5hbWUiOiJ4aWFvaGVpIn0.ipsEpp52hbuQhBF6FOpEaqH2olDd8KrvnZxDwfixSXU");
        System.out.println(verify.getClaim("userId").asString());
        System.out.println(verify.getClaim("username").asString());
        System.out.println(verify.getExpiresAt());
    }

}
