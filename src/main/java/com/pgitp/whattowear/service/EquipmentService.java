package com.pgitp.whattowear.service;

import com.pgitp.whattowear.config.DroolsBeanFactory;
import com.pgitp.whattowear.drools.models.Equipment;
import com.pgitp.whattowear.drools.models.Weather;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EquipmentService {

    KieSession kieSession=new DroolsBeanFactory().getKieSession();

    public Equipment suggestEquipment(Weather weather, Equipment suggestEquipment) throws IOException {
        kieSession.insert(weather);
        kieSession.setGlobal("suggestEquipment", suggestEquipment);
        kieSession.fireAllRules();
        System.out.println(suggestEquipment.getToTake());
        return suggestEquipment;

    }
}
