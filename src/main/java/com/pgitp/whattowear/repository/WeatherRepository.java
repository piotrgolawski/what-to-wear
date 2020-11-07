package com.pgitp.whattowear.repository;

import com.pgitp.whattowear.drools.models.Weather;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends ReactiveCrudRepository<Weather, String> {
}
