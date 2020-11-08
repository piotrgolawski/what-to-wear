package com.pgitp.whattowear.classes;

import com.pgitp.whattowear.drools.models.Equipment;
import com.pgitp.whattowear.drools.models.Weather;
import com.pgitp.whattowear.forecastApi.weatherAPI.WeatherApi;
import com.pgitp.whattowear.model.TripForecastRequest;
import com.pgitp.whattowear.model.TripForecastResponse;
import com.pgitp.whattowear.drools.service.EquipmentService;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WhatToWearCalculate {

    @Autowired
    private WeatherApi weatherApi;

    @Autowired
    private EquipmentService equipmentService;

    public TripForecastResponse calculateForTrip(TripForecastRequest tripForecastRequest) {
        TripForecastResponse simpleTripForecastFor = weatherApi.getSimpleTripForecastFor(tripForecastRequest);

        simpleTripForecastFor.setYouWillNeedBeforeFlight(
                this.calculate(simpleTripForecastFor.getWeatherBeforeFlight()).getToTakeString());


        List<String> collect = simpleTripForecastFor.getWeatherAfterFlight().stream()
                .map(this::calculate)
                .map(Equipment::getToTake)
                .filter(strings -> !strings.isEmpty())
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());


        simpleTripForecastFor.setYouWillNeedAfterFlight(String.join(", ", collect));

        return simpleTripForecastFor;
    }

    private Equipment calculate(Weather weather) {
        Equipment suggestEquipment = new Equipment();

        try {
            equipmentService.suggestEquipment(weather, suggestEquipment);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return suggestEquipment;
    }
}
