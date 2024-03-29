package com.tensequare;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

public class CreateJwt {
    @Test
    public void fs(){
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
//                .setHeaderParam(, )
//               .setAudience("")
//                .setExpiration(new Date(new Date().getTime()+60000))
                .claim("role", "admin");//2ge 一起生成签名
        System.out.println(jwtBuilder.compact());

    }

}
