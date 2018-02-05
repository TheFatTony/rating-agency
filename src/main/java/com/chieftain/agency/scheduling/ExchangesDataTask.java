package com.chieftain.agency.scheduling;


import com.chieftain.agency.dao.tickerdata.TickerDataDao;
import com.chieftain.agency.entity.TickerData;
import com.chieftain.agency.exchanges.ExchangesRegistry;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class ExchangesDataTask {

    private static final Logger log = LoggerFactory.getLogger(ExchangesDataTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private ExchangesRegistry exchangesRegistry;

    @Autowired
    private TickerDataDao tickerDataDao;

    @Autowired
    private ModelMapper modelMapper;


    @Scheduled(fixedRate = 43200000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));

        final Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = exchangesRegistry.poloniexExchange().getExchangeMetaData().getCurrencyPairs();

        for (CurrencyPair pair : currencyPairs.keySet()) {
            final CurrencyPairMetaData pairMetaData = currencyPairs.get(pair);
            System.out.printf("%s: %s%nn", pair, pairMetaData);
            try {
                Ticker ticker = exchangesRegistry.poloniexExchange().getMarketDataService().getTicker(pair);
                TickerData dbTicker = convertToEntity(ticker);
                dbTicker.setExchange("poloniex");
                dbTicker.setCurrencyBase(ticker.getCurrencyPair().base.getCurrencyCode());
                dbTicker.setCurrencyBase(ticker.getCurrencyPair().counter.getCurrencyCode());

                tickerDataDao.save(dbTicker);

                System.out.println(ticker);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private TickerData convertToEntity(Ticker item) {
        TickerData result = modelMapper.map(item, TickerData.class);
        return result;
    }

}
