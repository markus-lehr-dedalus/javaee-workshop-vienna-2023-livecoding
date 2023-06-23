package com.dedalus.service;

import com.dedalus.config.ApiNinjaKeyConfig;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class ApiNinjaServiceTest {
    @Inject
    ApiNinjaService apiNinjaService;

    @Inject
    @RestClient
    ApiNinjaRestClient restClient;

    @Inject
    ApiNinjaKeyConfig apiNinjaConfig;

    @Test
    public void testServiceFiveTimes() {
        for (int i = 0; i < 5; i++) {
            apiNinjaService.getAirQuality("Vienna");
        }
    }

    @Test
    public void verifyFailingRestClient() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < 5; i++) {
                restClient.getAirQuality("Vienna", apiNinjaConfig.getApiNinjaKey());
            }
        });
    }
}