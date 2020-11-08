package com.pgitp.whattowear.forecastApi.weatherAPI.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hour {
    @JsonProperty("time")
    private String time;
    @JsonProperty("temp_c")
    private Double tempC;
    @JsonProperty("is_day")
    private Long isDay;
    @JsonProperty("wind_kph")
    private Double windKph;
    @JsonProperty("precip_mm")
    private Double precipMm;
}