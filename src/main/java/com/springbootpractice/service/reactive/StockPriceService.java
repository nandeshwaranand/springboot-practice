package com.springbootpractice.service.reactive;

import com.springbootpractice.entity.StockPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class StockPriceService {

    private final Random random = new Random();

    public Flux<StockPrice> getStockPrices() {
        return Flux.interval(Duration.ofSeconds(1))  // Emit data every second
                .map(i -> new StockPrice(
                        "AAPL", // Stock symbol (Apple)
                        generateRandomPrice(),
                        LocalDateTime.now()
                ));
    }

    private BigDecimal generateRandomPrice() {
        return BigDecimal.valueOf(100 + random.nextDouble() * 50);
    }
}

