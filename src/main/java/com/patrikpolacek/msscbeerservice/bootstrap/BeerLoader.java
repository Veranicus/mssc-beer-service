package com.patrikpolacek.msscbeerservice.bootstrap;

import com.patrikpolacek.msscbeerservice.domain.Beer;
import com.patrikpolacek.msscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder().beerName("Kingswood red")
                    .beerStyle("fruit")
                    .price(BigDecimal.valueOf(2L))
                    .upc(34343L)
                    .minOnHand(12)
                    .build());

            beerRepository.save(Beer.builder().beerName("Heinekenn")
                    .beerStyle("classic")
                    .price(BigDecimal.valueOf(3L))
                    .upc(343423L)
                    .minOnHand(10)
                    .build());
        }

        System.out.println("Count of loaded beers: " + beerRepository.count());
    }
}
