package com.dedalus.service;

import com.dedalus.config.ApiNinjaKeyConfig;
import com.dedalus.model.AirQuality;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ApiNinjaService {
    @Inject
    ApiNinjaKeyConfig apiNinjaConfig;

    @Inject
    @RestClient
    ApiNinjaRestClient apiNinjaRestClient;

    @Retry(maxRetries = 5)
    public AirQuality getAirQuality(String city) {
        return apiNinjaRestClient.getAirQuality(city, apiNinjaConfig.getApiNinjaKey());
    }
}
