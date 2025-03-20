package com.springbootpractice.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Slf4j
public class PrimarySubclass implements ParentClass {

    @Override
    public String getPrimaryBean() {
        return "Primary Bean";
    }
}
