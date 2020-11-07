package com.pgitp.whattowear.forecastApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hour {

    @JsonProperty("time_epoch")
    private Long timeEpoch;
    @JsonProperty("time")
    private String time;
    @JsonProperty("temp_c")
    private Double tempC;
    @JsonProperty("temp_f")
    private Double tempF;
    @JsonProperty("is_day")
    private Long isDay;
    @JsonProperty("wind_mph")
    private Double windMph;
    @JsonProperty("wind_kph")
    private Double windKph;
    @JsonProperty("wind_degree")
    private Long windDegree;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("pressure_mb")
    private Double pressureMb;
    @JsonProperty("pressure_in")
    private Double pressureIn;
    @JsonProperty("precip_mm")
    private Double precipMm;
    @JsonProperty("precip_in")
    private Double precipIn;
    @JsonProperty("humidity")
    private Long humidity;
    @JsonProperty("cloud")
    private Long cloud;
    @JsonProperty("feelslike_c")
    private Double feelslikeC;
    @JsonProperty("feelslike_f")
    private Double feelslikeF;
    @JsonProperty("windchill_c")
    private Double windchillC;
    @JsonProperty("windchill_f")
    private Double windchillF;
    @JsonProperty("heatindex_c")
    private Double heatindexC;
    @JsonProperty("heatindex_f")
    private Double heatindexF;
    @JsonProperty("dewpoint_c")
    private Double dewpointC;
    @JsonProperty("dewpoint_f")
    private Double dewpointF;
    @JsonProperty("will_it_rain")
    private Long willItRain;
    @JsonProperty("chance_of_rain")
    private String chanceOfRain;
    @JsonProperty("will_it_snow")
    private Long willItSnow;
    @JsonProperty("chance_of_snow")
    private String chanceOfSnow;
    @JsonProperty("vis_km")
    private Double visKm;
    @JsonProperty("vis_miles")
    private Double visMiles;
    @JsonProperty("gust_mph")
    private Double gustMph;
    @JsonProperty("gust_kph")
    private Double gustKph;

}