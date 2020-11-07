package com.pgitp.whattowear;

import com.pgitp.whattowear.classes.WhatToWearCalculate;
import com.pgitp.whattowear.controllers.WearController;
import com.pgitp.whattowear.forecastApi.WeatherApi;
import com.pgitp.whattowear.service.EquipmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackageClasses =
        {WearController.class, WhatToWearCalculate.class,
                WeatherApi.class, EquipmentService.class}, exclude={SecurityAutoConfiguration.class})
@Configuration
public class WhatToWearApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatToWearApplication.class, args);
    }

}
