package com.dedalus;

import com.dedalus.model.AirQuality;
import com.dedalus.model.AirQualityEntry;
import com.dedalus.service.ApiNinjaRestClient;
import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@Mock
@RestClient
public class FailingApiNinjaRestClient implements ApiNinjaRestClient {
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public AirQuality getAirQuality(String city, String apiKey) {
        if (counter.incrementAndGet() % 3 != 0) {
            throw new RuntimeException();
        }

        AirQuality airQuality = new AirQuality();
        airQuality.overall_aqi = 5;
        airQuality.CO = new AirQualityEntry();
        airQuality.NO2 = new AirQualityEntry();
        return airQuality;
    }
}
