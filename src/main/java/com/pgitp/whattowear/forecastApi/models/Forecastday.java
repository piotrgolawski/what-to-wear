package com.pgitp.whattowear.forecastApi.models;

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
//    @JsonProperty("date_epoch")
//    public Long dateEpoch;
    @JsonProperty("day")
    public Day day;
//    @JsonProperty("hour")
//    public List<Hour> hour = null;
}
