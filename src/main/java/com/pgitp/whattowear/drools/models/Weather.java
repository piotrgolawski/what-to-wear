package com.pgitp.whattowear.drools.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Double tempC;
    private Double windKph;
    private Double uv;
    private Boolean canRain;
}
