package com.springbootpractice.service.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ReactorService {

    public void reactorTest(){

        // Publish multiple data 0...n
        Flux<String> publisher = Flux.just("Hello","World");//.log();
        publisher.subscribe(new CustomSubscriber());

        //Publish single data only
        Mono<String> mono = Mono.just("Anand");
        mono.subscribe(new CustomSubscriber());
        fluxTest();
    }

    public void fluxTest() {
        Flux.range(1, 100) // Producing 100 values
                .log()
                .publishOn(Schedulers.boundedElastic()) // Asynchronous processing
                .subscribe(
                        item -> {
                            try {
                                Thread.sleep(50); // Simulate slow processing
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Received: " + item);
                        }
                );
    }
}
