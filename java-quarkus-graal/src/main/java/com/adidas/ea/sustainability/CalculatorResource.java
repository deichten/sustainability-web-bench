package com.adidas.ea.sustainability;

import java.util.Collections;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestPath;

@Path("/calc")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorResource {

    @GET
    @Path("/add/{first}/{second}")
    public Map<String, Object> add(@RestPath("first") int first, @RestPath("second") int second) {
        return Collections.singletonMap("result", first + second);
    }

    @GET
    @Path("/sub/{first}/{second}")
    public Map<String, Object> sub(@RestPath("first") int first, @RestPath("second") int second) {
        return Collections.singletonMap("result", first - second);
    }

    @GET
    @Path("/mul/{first}/{second}")
    public Map<String, Object> mul(@RestPath("first") int first, @RestPath("second") int second) {
        return Collections.singletonMap("result", first * second);
    }

    @GET
    @Path("/div/{first}/{second}")
    public Map<String, Object> div(@RestPath("first") int first, @RestPath("second") int second) {
        if (second == 0) {
            return Collections.singletonMap("error", "Division by zero");
        }

        return Collections.singletonMap("result", first / second);
    }

}
