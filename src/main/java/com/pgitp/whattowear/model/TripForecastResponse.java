package com.pgitp.whattowear.model;

import com.pgitp.whattowear.drools.models.Weather;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TripForecastResponse {

    public TripForecastResponse(int tripDaysConsideredByApi, Weather weatherBeforeFlight, List<Weather> weatherAfterFlight) {
        this.tripDaysConsideredByApi = tripDaysConsideredByApi;
        this.weatherBeforeFlight = weatherBeforeFlight;
        this.weatherAfterFlight = weatherAfterFlight;
    }

    private int tripDaysConsideredByApi = 3;
    private String youWillNeedBeforeFlight;
    private String youWillNeedAfterFlight;
    private Weather weatherBeforeFlight;
    private List<Weather> weatherAfterFlight;
}
