package com.pgitp.whattowear.forecastApi.weatherAPI;

import com.google.common.util.concurrent.AtomicDouble;
import com.pgitp.whattowear.drools.models.Weather;
import com.pgitp.whattowear.forecastApi.weatherAPI.models.FullForecast;
import com.pgitp.whattowear.model.TripForecastRequest;
import com.pgitp.whattowear.model.TripForecastResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@PropertySource(value={"classpath:weatherapi.properties"})
public class WeatherApi {
    @Value("${weatherApi.url}")
    private String weatherApiUrl;

    @Value("${weatherApi.currentDay}")
    private String weatherApiCurrent;

    @Value("${weatherApi.forecast}")
    private String weatherApiForecast;

    @Value("${weatherApi.key}")
    private String weatherApiKey;

    public TripForecastResponse getSimpleTripForecastFor(TripForecastRequest tripForecastRequest) {
        Weather forecastBeforeFlight = getWeather(tripForecastRequest.getFrom(),0).get(0);
        List<Weather> simpleForecasts = getWeather(tripForecastRequest.getTo(), tripForecastRequest.getDays());

        return new TripForecastResponse(forecastBeforeFlight, simpleForecasts);
    }

    public List<Weather> getWeather(String place, int days) {
        LocalDateTime now = LocalDateTime.now();
        AtomicDouble tempUvFromDay = new AtomicDouble(0.0);

        return getFullForecastFor(place, days)
                .getForecast().getForecastday().stream()
                .peek(forecastday -> tempUvFromDay.set(forecastday.getDay().getUv()))
                .flatMap(forecastday -> Stream.of(forecastday.getHours()))
                .flatMap(Collection::stream)
                .filter(hour -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime measurementTime = LocalDateTime.parse(hour.getTime(), formatter);
                    return measurementTime.isAfter(now);
                })
                .map(hour -> new Weather(
                        hour.getTempC(),
                        hour.getWindKph(),
                        tempUvFromDay.get(),
                        hour.getPrecipMm()
                ))
                .collect(Collectors.toList());
    }

    private FullForecast getFullForecastFor(String city, int days) {
        StringBuilder stringBuilder = new StringBuilder(this.weatherApiUrl);
        days = Math.min(Math.max(days, 1), 10);

        stringBuilder.append(weatherApiForecast);
        stringBuilder.append(weatherApiKey);
        stringBuilder.append("&days=");
        stringBuilder.append(days);
        stringBuilder.append("&q=");
        stringBuilder.append(city);

        return getForecastByUrl(stringBuilder.toString());
    }

    private FullForecast getForecastByUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, FullForecast.class);
    }
}
