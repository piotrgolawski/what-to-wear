package com.pgitp.whattowear.forecastApi.weatherAPI.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Condition {
    private String text;
    private String icon;
    private Integer code;
}

