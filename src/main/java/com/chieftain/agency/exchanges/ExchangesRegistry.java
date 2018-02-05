package com.chieftain.agency.exchanges;


import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.poloniex.PoloniexExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExchangesRegistry {

    @Bean
    public PoloniexExchange poloniexExchange() {
        ExchangeSpecification spec = new ExchangeSpecification(PoloniexExchange.class);

        return (PoloniexExchange) ExchangeFactory.INSTANCE.createExchange(spec);
    }


}
