package com.pgitp.whattowear.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.ArrayList;
import java.util.List;

public class DroolsBeanFactory {

    private static final String RULES_PATH = "rules/";
    private static final List<String> ruleFiles = new ArrayList<>() {{
        add("SuggestWear.drl");
    }};

    private KieServices kieServices=KieServices.Factory.get();

    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(() -> kieRepository.getDefaultReleaseId());
    }

    public KieSession getKieSession(){
        getKieRepository();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        ruleFiles.forEach(ruleFile -> kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + ruleFile)));


        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kContainer.newKieSession();
    }
}
