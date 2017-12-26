package com.chieftain.agency.rest.resources;


import com.chieftain.agency.dao.currencyrating.CurrencyRatingDao;
import com.chieftain.agency.dao.icolist.IcoListDao;
import com.chieftain.agency.dao.news.NewsDao;
import com.chieftain.agency.entity.CurrencyRating;
import com.chieftain.agency.entity.IcoList;
import com.chieftain.agency.entity.News;
import com.chieftain.agency.transfer.CurrencyRatingDto;
import com.chieftain.agency.transfer.IcoListDto;
import com.chieftain.agency.transfer.NewsDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/main")
public class MainPageResources {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private CurrencyRatingDao currencyRatingDao;

    @Autowired
    private IcoListDao icoListDao;

    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/news/{lang}")
    public List<NewsDto> listNews(@PathParam("lang") String lang) throws IOException {
        this.logger.info("listPublic()");
        System.out.println("lang = " + lang);
        List<News> allEntries = this.newsDao.findFirstByLang(lang);
        return allEntries.stream().map(allEntry -> convertToNewsDto(allEntry)).collect(Collectors.toList());
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/currencies/{lang}")
    public List<CurrencyRatingDto> listCurrencies() throws IOException {
        this.logger.info("list()");
        List<CurrencyRating> allEntries = this.currencyRatingDao.findFirstRows();
        return allEntries.stream()
                .map(allEntry -> convertToCurrenciesDto(allEntry))
                .collect(Collectors.toList());
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/icos/{lang}")
    public List<IcoListDto> listIcos() throws IOException {
        this.logger.info("list()");
        List<IcoList> allEntries = this.icoListDao.findFirstRows();
        return allEntries.stream().map(allEntry -> convertToIcosDto(allEntry)).collect(Collectors.toList());
    }

    private CurrencyRatingDto convertToCurrenciesDto(CurrencyRating currencyRating) {
        CurrencyRatingDto currencyRatingDto = modelMapper.map(currencyRating, CurrencyRatingDto.class);
        return currencyRatingDto;
    }

    private NewsDto convertToNewsDto(News news) {
        NewsDto icoListDto = modelMapper.map(news, NewsDto.class);
        return icoListDto;
    }


    private IcoListDto convertToIcosDto(IcoList icoList) {
        IcoListDto icoListDto = modelMapper.map(icoList, IcoListDto.class);
        return icoListDto;
    }


}
