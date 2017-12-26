package com.chieftain.agency.scheduling;


import com.chieftain.agency.dao.icolist.IcoListDao;
import com.chieftain.agency.entity.IcoList;
import com.chieftain.agency.model.IcoAlertEntities;
import com.chieftain.agency.model.IcoAlertEntity;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

@Component
public class IcoAlertDataTask {

    private static final Logger log = LoggerFactory.getLogger(IcoAlertDataTask.class);

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
        HttpEntity<String> response = restTemplate.exchange("https://www.icoalert.com/icos/api.json", HttpMethod.GET, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        IcoAlertEntities emp = null;
        try {
            emp = objectMapper.readValue(response.getBody().toString(), IcoAlertEntities.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNativeQuery("delete from ico_list").executeUpdate();
        tx.commit();
        em.close();

        for (IcoAlertEntity s : emp.getIcos()) {
            IcoList icoList = convertToEntity(s);
            Calendar c = Calendar.getInstance();
            c.setTime(s.getStartDate());
            c.add(Calendar.DATE, s.getDaysTillEnd());
            icoList.setEndDate(c.getTime());
            this.icoListDao.save(icoList);
        }

        for (IcoAlertEntity s : emp.getUpcoming()) {
            IcoList icoList = convertToEntity(s);
            Calendar c = Calendar.getInstance();
            c.setTime(s.getStartDate());
            c.add(Calendar.DATE, s.getDaysTillEnd());
            icoList.setEndDate(c.getTime());
            this.icoListDao.save(icoList);
        }

    }

    private void saveItem(IcoAlertEntity s) {
        IcoList icoList = new IcoList();
        icoList.setDescription(s.getDescription());
        icoList.setTitle(s.getTitle());
        icoList.setDescription(s.getDescription());
        icoList.setStartDate(s.getStartDate());

        Calendar c = Calendar.getInstance();
        c.setTime(s.getStartDate());
        c.add(Calendar.DATE, s.getDaysTillEnd());
        icoList.setEndDate(c.getTime());

        icoList.setWebsite(s.getWebsite());


        log.info(s.getReportAvailable());
        StringBuffer sb = null;
        String content = null;
        if ("yes".equals(s.getReportAvailable())) {
            sb = new StringBuffer();
            RestTemplate httpClient = new RestTemplate();
            if (s.getReportLink() != null) {
                try {
                    HttpEntity<String> webPage = httpClient.exchange(s.getReportLink(), HttpMethod.GET, entity, String.class);
                    String page = webPage.getBody().toString();
                    String pageJson = page.substring(page.indexOf("window[\"obvInit\"]({"));
                    final String json = pageJson.substring(18, pageJson.indexOf("}}}}") + 4);
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        JsonNode actualObj = mapper.readTree(json);
                        Iterator<JsonNode> jsonNodes = actualObj.get("value").get("content").get("bodyModel").get("paragraphs").elements();

                        for (Iterator<JsonNode> it = jsonNodes; it.hasNext(); ) {
                            JsonNode jn = it.next();
                            if (jn.get("type").asInt() == 1) {
                                sb.append(jn.get("text").asText());
                                sb.append("\n");
                            }
                        }
                        content = sb.toString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        icoList.setContent(content);

        this.icoListDao.save(icoList);
    }

    private IcoList convertToEntity(IcoAlertEntity icoAlertEntity) {
        IcoList currencyRatingDto = modelMapper.map(icoAlertEntity, IcoList.class);
        return currencyRatingDto;
    }
}
