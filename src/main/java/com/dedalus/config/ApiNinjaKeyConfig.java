package com.dedalus.config;

import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Getter
public class ApiNinjaKeyConfig {
    @ConfigProperty(name = "API_NINJA_KEY")
    String apiNinjaKey;
}
