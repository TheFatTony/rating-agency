package com.chieftain.agency.rest.resources;

import com.chieftain.agency.dao.news.NewsDao;
import com.chieftain.agency.entity.News;
import com.chieftain.agency.transfer.NewsDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/news")
public class NewsResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{lang}")
    public List<NewsDto> listPublic(@PathParam("lang") String lang) throws IOException {
        this.logger.info("listPublic()");
        System.out.println("lang = " + lang);
        List<News> allEntries = this.newsDao.findAllByLang(lang);
        return allEntries.stream().map(allEntry -> convertToDto(allEntry)).collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/top/{lang}")
    public List<NewsDto> listNews(@PathParam("lang") String lang) throws IOException {
        this.logger.info("listNews()");
        System.out.println("lang = " + lang);
        List<News> allEntries = this.newsDao.findTopByLang(lang);
        return allEntries.stream().map(allEntry -> convertToDto(allEntry)).collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{lang}/{id}")
    public NewsDto readPublic(@PathParam("lang") String lang, @PathParam("id") Long id) {
        this.logger.info("readPublic(id)");
        News item = this.newsDao.find(id);
        if (item == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return convertToDto(item);
    }

    private NewsDto convertToDto(News news) {
        NewsDto icoListDto = modelMapper.map(news, NewsDto.class);
        return icoListDto;
    }

    private News convertFromDto(NewsDto newstDto) {
        News news = modelMapper.map(newstDto, News.class);
        return news;
    }
}
