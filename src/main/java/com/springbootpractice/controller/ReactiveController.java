package com.springbootpractice.controller;

import com.springbootpractice.entity.StockPrice;
import com.springbootpractice.service.reactive.ReactorService;
import com.springbootpractice.service.reactive.StockPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping("/reactive")
@RestController
public class ReactiveController {

    private final ReactorService reactorService;

    private final StockPriceService stockPriceService;

    public ReactiveController(ReactorService reactorService, StockPriceService stockPriceService) {
        this.reactorService = reactorService;
        this.stockPriceService = stockPriceService;
    }

    @PostMapping("/test")
    public ResponseEntity<Object> reactiveTest(){
        reactorService.reactorTest();
        return ResponseEntity.status(HttpStatus.CREATED).body("Reactive is successful.");
    }

    /**
     * produces = "text/event-stream"
     * ensures the API streams real-time data using Server-Sent Events (SSE).
     * @return Flux<StockPrice>
     */
    @GetMapping(value = "/stock", produces = "text/event-stream")
    public Flux<StockPrice> streamStockPrices() {
        return stockPriceService.getStockPrices();
    }
}
