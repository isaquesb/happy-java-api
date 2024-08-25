package com.github.isaquesb.happy_java_api.domain.orphanages.create_steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Chain {

    @Autowired
    private ApplicationContext context;

    public <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public Chain() {;
    }

    public String execute(CreateRequest request) throws Exception {
        Arrays.asList(
                getBean(SetUuid.class),
                getBean(PersistOrphanage.class),
                getBean(UploadImages.class)
        ).forEach(step -> {
            try {
                step.fill(request);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return request.orphanage().getUuid();
    }
}
