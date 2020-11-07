package com.pgitp.whattowear.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
public class TripForecastRequest {
    private String from;
    private String to;

    @Max(10) @Min(1)
    private int days;
}
