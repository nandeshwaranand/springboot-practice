package com.springbootpractice.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationReadyEvent is a event listener class which is listen the event on application ready.
 * Once application is loaded/initialized all the beans and server started
 * then this event will be triggered
 */
@Component
@Slf4j
public class StatrupListener {

    @EventListener(ApplicationReadyEvent.class)
    public void startupSetup(){
        log.info("On Application ready (fully initialized) application ready event is triggered.)");
    }
}
