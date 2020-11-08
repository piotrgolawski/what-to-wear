package com.pgitp.whattowear.forecastApi.weatherAPI.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullForecast {
    private Location location;
    private Current current;
    private Forecast forecast;
}
