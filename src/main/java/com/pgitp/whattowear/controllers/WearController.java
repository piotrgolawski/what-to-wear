package com.pgitp.whattowear.controllers;

import com.pgitp.whattowear.classes.WhatToWearCalculate;
import com.pgitp.whattowear.model.TripForecastRequest;
import com.pgitp.whattowear.model.TripForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("wear/")
public class WearController {

    @Autowired
    private WhatToWearCalculate whatToWearCalculate;

    @PostMapping(path = "/airplane-trip", consumes = "application/json", produces = "application/json")
    @ResponseBody
    TripForecastResponse getAirplaneForecast(@RequestBody @Valid TripForecastRequest tripForecastRequest) {
        return this.whatToWearCalculate.calculateForTrip(tripForecastRequest);
    }
}
