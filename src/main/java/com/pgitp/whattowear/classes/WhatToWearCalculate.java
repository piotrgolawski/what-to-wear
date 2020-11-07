package com.pgitp.whattowear.classes;

import com.pgitp.whattowear.drools.models.Equipment;
import com.pgitp.whattowear.drools.models.Weather;
import com.pgitp.whattowear.forecastApi.WeatherApi;
import com.pgitp.whattowear.model.TripForecastRequest;
import com.pgitp.whattowear.model.TripForecastResponse;
import com.pgitp.whattowear.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WhatToWearCalculate {

    @Autowired
    private WeatherApi weatherApi;

    @Autowired
    private EquipmentService equipmentService;

    public String calculateForNow(String city) {
        Weather weather = weatherApi.getSimpleForecastFor(city).toWeather();
        return calculate(weather).getToTakeString();
    }

    public TripForecastResponse calculateForTrip(TripForecastRequest tripForecastRequest) {
        TripForecastResponse simpleTripForecastFor = weatherApi.getSimpleTripForecastFor(tripForecastRequest);

        Set<String> itemsSet = simpleTripForecastFor.getWeatherAfterFlight().stream()
                .map(this::calculate)
                .map(Equipment::getToTake)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

       simpleTripForecastFor.setYouWillNeedBeforeFlight(
               this.calculate(simpleTripForecastFor.getWeatherBeforeFlight()).getToTakeString());
        simpleTripForecastFor.setYouWillNeedAfterFlight(String.join(", ", itemsSet));

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
