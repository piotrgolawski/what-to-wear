package com.pgitp.whattowear.service;


import com.pgitp.whattowear.drools.models.Equipment;
import com.pgitp.whattowear.drools.models.Weather;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ApplicantServiceIntegrationEquipmentTest {

    private EquipmentService equipmentService;

    @Before
    public void setup() {
        equipmentService = new EquipmentService();
    }

    @Test
    public void whenCriteriaMatching_ThenSuggestWearJacket() throws IOException {
        Weather weather = new Weather(10d, 30d, 30d, true);
        Equipment suggestEquipment = new Equipment();
        equipmentService.suggestEquipment(weather, suggestEquipment);
        assertEquals("Windbreaker Jacket, Umbrella", suggestEquipment.getToTakeString());
    }
}
