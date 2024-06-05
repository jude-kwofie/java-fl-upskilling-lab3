package com.mextech.lab_3;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app")
@Validated
public record ApplicationProperties(int port, DatabaseProperties database) {

    public record DatabaseProperties(
            @NotEmpty String host,
            @Positive int port,
            @NotEmpty String username,
            @NotEmpty String password,

            @NotEmpty String database_name
    ){

    }

}
