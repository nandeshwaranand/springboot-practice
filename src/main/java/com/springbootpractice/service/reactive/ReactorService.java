package com.springbootpractice.service.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactorService {

    public void reactorTest(){

        // Publish multiple data 0...n
        Flux<String> publisher = Flux.just("Hello","World");//.log();
        publisher.subscribe(new CustomSubscriber());

        //Publish single data only
        Mono<String> mono = Mono.just("Anand");
        mono.subscribe(new CustomSubscriber());
    }
}
