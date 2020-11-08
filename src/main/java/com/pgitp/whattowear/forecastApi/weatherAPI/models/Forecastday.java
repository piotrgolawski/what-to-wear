package com.pgitp.whattowear.forecastApi.weatherAPI.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

@Getter
@Setter
public class Forecastday {
    @JsonProperty("date")
    public String date;
    @JsonProperty("day")
    public Day day;
    @JsonProperty("hour")
    private List<Hour> hours = Lists.newArrayList();
}
