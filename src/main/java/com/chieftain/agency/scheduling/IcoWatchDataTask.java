package com.chieftain.agency.scheduling;


import com.chieftain.agency.dao.icolist.IcoListDao;
import com.chieftain.agency.entity.IcoList;
import com.chieftain.agency.model.IcoWatchEntities;
import com.chieftain.agency.model.IcoWatchEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class IcoWatchDataTask {

    private static final Logger log = LoggerFactory.getLogger(IcoWatchDataTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private IcoListDao icoListDao;

    @Autowired
    private EntityManagerFactory emf;

    private HttpEntity entity;

    @Autowired
    private ModelMapper modelMapper;


    @Scheduled(initialDelay = 43200000, fixedRate = 43200000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));


        HttpHeaders headers = new HttpHeaders();
        headers.set("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");


        entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange("https://api.icowatchlist.com/public/v1/", HttpMethod.GET, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        IcoWatchEntities emp = null;

        System.out.println(response.getBody().toString());
        try {
            emp = objectMapper.readValue(response.getBody().toString(), IcoWatchEntities.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNativeQuery("delete from ico_list").executeUpdate();
        tx.commit();
        em.close();

        for (IcoWatchEntity s : emp.getLive()) {
            IcoList icoList = convertToEntity(s);
            icoList.setStatus("Live");
            this.icoListDao.save(icoList);
        }

        for (IcoWatchEntity s : emp.getUpcoming()) {
            IcoList icoList = convertToEntity(s);
            icoList.setStatus("Upcoming");
            this.icoListDao.save(icoList);
        }

        for (IcoWatchEntity s : emp.getFinished()) {
            IcoList icoList = convertToEntity(s);
            icoList.setStatus("Finished");
            this.icoListDao.save(icoList);
        }

    }

    private IcoList convertToEntity(IcoWatchEntity icoAlertEntity) {
        IcoList currencyRatingDto = modelMapper.map(icoAlertEntity, IcoList.class);
        return currencyRatingDto;
    }
}
