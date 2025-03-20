package com.springbootpractice.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondarySubclass implements ParentClass {

    @Override
    public String getPrimaryBean() {
        log.info("Secondary bean");
        return "Secondary Bean";
    }
}
