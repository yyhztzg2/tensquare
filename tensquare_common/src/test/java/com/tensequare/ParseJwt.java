package com.tensequare;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import sun.management.VMOptionCompositeData;

public class ParseJwt {
    @Test
    public void fd(){
        Jws<Claims> itcast = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NjYyODc1OTAsInJvbGUiOiJhZG1pbiJ9.2hAGGKmcEQVS4CrBCzfq2pPQEoKb4aTsABU-69EZOxQ");
        Claims body = itcast.getBody();
        System.out.println(body.getId()+"  "+body.getIssuedAt()+" "+body.getSubject()+" "+body.getExpiration()+" "+body.get("role" ) );
    }
}
