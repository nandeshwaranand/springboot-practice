package com.springbootpractice.components;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondarySubclass implements ParentClass {

    @Override
    public String getPrimaryBean() {
        return "Secondary Bean";
    }
}
