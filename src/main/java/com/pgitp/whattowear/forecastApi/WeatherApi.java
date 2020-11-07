package com.pgitp.whattowear.forecastApi;

import com.pgitp.whattowear.drools.models.Weather;
import com.pgitp.whattowear.forecastApi.models.FullForecast;
import com.pgitp.whattowear.forecastApi.models.SimpleForecast;
import com.pgitp.whattowear.model.TripForecastRequest;
import com.pgitp.whattowear.model.TripForecastResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        SimpleForecast forecastBeforeFlight = getSimpleForecastFor(tripForecastRequest.getFrom());
        List<Weather> simpleForecasts =
                getFullForecastFor(tripForecastRequest.getTo(), tripForecastRequest.getDays())
                        .getForecast().getForecastday().stream()
                        .flatMap(forecastday -> Stream.of(forecastday.getDay()))
                        .map(day -> new SimpleForecast(
                                tripForecastRequest.getTo(),
                                day.getAvgtempC(),
                                day.getMaxwindKph(),
                                day.getUv(),
                                Integer.parseInt(day.getDailyChanceOfSnow()) > 0 || Integer.parseInt(day.getDailyChanceOfSnow()) > 0,
                                false
                        ))
                        .map(SimpleForecast::toWeather)
                        .collect(Collectors.toList());

        return new TripForecastResponse(simpleForecasts.size(), forecastBeforeFlight.toWeather(), simpleForecasts);
    }

    public SimpleForecast getSimpleForecastFor(String city) {
        FullForecast fullForecast = getFullForecastForTodayFor(city);

//        tu powinienem brac ten sam forecast, bo tam jest srednia szansa w dniu, a nie wiesz czy teraz leci czy pozniej
        // a najlepiej tylko houry po teraz
        return new SimpleForecast(
                fullForecast.getLocation().getName(),
                fullForecast.getCurrent().getTempC(),
                fullForecast.getCurrent().getWindKph(),
                fullForecast.getCurrent().getUv(),
                fullForecast.getCurrent().getPrecipMm() > 0,
                true
        );
    }

    private FullForecast getFullForecastForTodayFor(String city) {
        return this.getFullForecastFor(city, 1);
    }

    private FullForecast getFullForecastFor(String city, int days) {
        StringBuilder stringBuilder = new StringBuilder(this.weatherApiUrl);
        days = Math.min(Math.max(days, 1), 10);

        if (days == 1) {
            stringBuilder.append(weatherApiCurrent);
            stringBuilder.append(weatherApiKey);
        } else {
            stringBuilder.append(weatherApiForecast);
            stringBuilder.append(weatherApiKey);
            stringBuilder.append("&days=");
            stringBuilder.append(days);
        }

        stringBuilder.append("&q=");
        stringBuilder.append(city);

        return getForecastByUrl(stringBuilder.toString());
    }

    private FullForecast getForecastByUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, FullForecast.class);
    }

}
