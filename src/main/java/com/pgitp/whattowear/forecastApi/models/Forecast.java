package com.pgitp.whattowear.forecastApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

@Getter
@Setter
public class Forecast {
    @JsonProperty("forecastday")
    public List<Forecastday> forecastday = Lists.newArrayList();
}
