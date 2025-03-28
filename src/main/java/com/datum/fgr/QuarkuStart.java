package com.datum.fgr;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class QuarkuStart {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Welcome to the First Quarkus App.";
    }
}
