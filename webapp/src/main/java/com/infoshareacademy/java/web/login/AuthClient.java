package com.infoshareacademy.java.web.login;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface AuthClient {

    @GET
    @Produces("text/plain")
    String getUserInfo(@HeaderParam("Authorization") String authorization);
    
}
