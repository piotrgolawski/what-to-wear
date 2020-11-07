package com.pgitp.whattowear.forecastApi.models;

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
    private Boolean cloud;
    private boolean beforeTrip = true;

    public Weather toWeather() {
        return new Weather(this.tempC, this.windKph, this.uv, this.cloud);
    }
}
