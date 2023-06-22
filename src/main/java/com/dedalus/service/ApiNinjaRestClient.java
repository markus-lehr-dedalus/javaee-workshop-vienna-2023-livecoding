package com.dedalus.service;

import com.dedalus.model.AirQuality;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1")
public interface ApiNinjaRestClient {
    @GET
    @Path("airquality")
    AirQuality getAirQuality(
            @QueryParam("city") String city,
            @HeaderParam("X-Api-Key") String apiKey);
}
