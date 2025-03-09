package com.springbootpractice.components;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The @PostConstruct annotation to execute some setup logic
 * before the file (or class) is fully initialized and ready to be used.
 * Spring Boot calls this method automatically after the bean (class) is created and its dependencies are injected.
 * It is useful for initializing resources, setting default values, or pre-loading data before a file (class) is used.
 */
@Component
@Slf4j
public class PostConstructAnnotation {

    @PostConstruct
    private void setup(){
        log.info("Post Construct called..");
    }
}
