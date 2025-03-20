package com.springbootpractice.service.reactive;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class CustomSubscriber implements Subscriber<String> {


    @Override
    public void onSubscribe(Subscription subscription) {
        log.info("onSubscribe get called..");
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String s) {
        log.info("onNext get called..");
        log.info("Receiving data:"+s);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("onError get called..");
    }

    @Override
    public void onComplete() {
        log.info("onComplete get called..");
    }
}
