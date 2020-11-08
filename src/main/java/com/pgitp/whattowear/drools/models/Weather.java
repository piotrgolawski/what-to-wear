package com.pgitp.whattowear.drools.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Double tempC;
    private Double windKph;
    private Double uv;
    private Double rainMM;
}
