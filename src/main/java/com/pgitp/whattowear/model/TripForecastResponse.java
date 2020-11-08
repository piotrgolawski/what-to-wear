package com.pgitp.whattowear.model;

import com.pgitp.whattowear.drools.models.Weather;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TripForecastResponse {

    public TripForecastResponse(Weather weatherBeforeFlight, List<Weather> weatherAfterFlight) {
        this.weatherBeforeFlight = weatherBeforeFlight;
        this.weatherAfterFlight = weatherAfterFlight;
    }

    private String youWillNeedBeforeFlight;
    private String youWillNeedAfterFlight;
    private Weather weatherBeforeFlight;
    private List<Weather> weatherAfterFlight;
}
