package com.dedalus.service;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.security.SecureRandom;

@ApplicationScoped
@Slf4j
public class ImportantService {
    private final double failProbability = 0.5;

    public boolean slowMethodThatCouldFail() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            log.error("Important method acutally failed unextectedly!", e);
            throw new RuntimeException(e);
        }
        SecureRandom secureRandom = new SecureRandom();
        if (secureRandom.nextDouble() < failProbability) {
            log.error("Important method failed!");
            throw new RuntimeException(); // intentionally non-descript :P
        }
        log.info("Important method succeeded!");
        return true;
    }
}
