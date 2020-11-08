package com.pgitp.whattowear.forecastApi.weatherAPI.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Day {
    @JsonProperty("uv")
    private Double uv;
}