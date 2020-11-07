package com.pgitp.whattowear.enums;

import lombok.Getter;

public enum CityEnum {
    WARSAW("Warsaw"),
    BERLIN("Berlin"),
    NEW_YORK("New York");

    @Getter
    private String name;

    CityEnum(String envUrl) {
        this.name = envUrl;
    }
}
