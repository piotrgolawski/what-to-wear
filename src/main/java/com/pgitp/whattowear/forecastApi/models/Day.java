package com.pgitp.whattowear.forecastApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Day {
    @JsonProperty("maxtemp_c")
    private Double maxtempC;
    @JsonProperty("maxtemp_f")
    private Double maxtempF;
    @JsonProperty("mintemp_c")
    private Double mintempC;
    @JsonProperty("mintemp_f")
    private Double mintempF;
    @JsonProperty("avgtemp_c")
    private Double avgtempC;
    @JsonProperty("avgtemp_f")
    private Double avgtempF;
    @JsonProperty("maxwind_mph")
    private Double maxwindMph;
    @JsonProperty("maxwind_kph")
    private Double maxwindKph;
    @JsonProperty("totalprecip_mm")
    private Double totalprecipMm;
    @JsonProperty("totalprecip_in")
    private Double totalprecipIn;
    @JsonProperty("avgvis_km")
    private Double avgvisKm;
    @JsonProperty("avgvis_miles")
    private Double avgvisMiles;
    @JsonProperty("avghumidity")
    private Double avghumidity;
    @JsonProperty("daily_will_it_rain")
    private Long dailyWillItRain;
    @JsonProperty("daily_chance_of_rain")
    private String dailyChanceOfRain;
    @JsonProperty("daily_will_it_snow")
    private Long dailyWillItSnow;
    @JsonProperty("daily_chance_of_snow")
    private String dailyChanceOfSnow;
    @JsonProperty("condition")
    private Condition condition;
    @JsonProperty("uv")
    private Double uv;

}