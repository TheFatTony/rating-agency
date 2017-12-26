package com.chieftain.agency.scheduling;


import com.chieftain.agency.dao.currencyrating.CurrencyRatingDao;
import com.chieftain.agency.entity.CurrencyRating;
import com.chieftain.agency.model.CoinMarketCapEntity;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CoinMarketCapDataTask {

    private static final Logger log = LoggerFactory.getLogger(CoinMarketCapDataTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private CurrencyRatingDao currencyRatingDao;

    @Autowired
    private EntityManagerFactory emf;

    private HttpEntity entity;

    @Autowired
    private ModelMapper modelMapper;


    @Scheduled(initialDelay = 3600000, fixedRate = 3600000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));


        RestTemplate restTemplate = new RestTemplate();
        CoinMarketCapEntity[] response = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", CoinMarketCapEntity[].class);


        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNativeQuery("delete from currency_rating").executeUpdate();
        tx.commit();
        em.close();

        for (CoinMarketCapEntity s : response) {
            CurrencyRating currencyRating = modelMapper.map(s, CurrencyRating.class);
            currencyRatingDao.save(currencyRating);
        }


    }


}
