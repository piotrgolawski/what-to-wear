package com.pgitp.whattowear.forecastApi.weatherAPI.models;

import com.pgitp.whattowear.drools.models.Weather;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimpleForecast {
    private String city;
    private Double tempC;
    private Double windKph;
    private Double uv;
    private Boolean canRain;
}
