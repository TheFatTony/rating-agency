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
@Path("/admin/news")
public class NewsAdminResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NewsDto> list() throws IOException {
        this.logger.info("list()");
        List<News> allEntries = this.newsDao.findAll();
        return allEntries.stream().map(allEntry -> convertToDto(allEntry)).collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public NewsDto read(@PathParam("id") Long id) {
        this.logger.info("read(id)");
        News item = this.newsDao.find(id);
        if (item == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return convertToDto(item);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public NewsDto create(NewsDto icoItem) {
        this.logger.info("create(): " + icoItem);
        News item = null;
        item = this.newsDao.save(convertFromDto(icoItem));
        return convertToDto(item);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public NewsDto update(@PathParam("id") Long id, NewsDto icoItem) {
        this.logger.info("update(): " + icoItem);
        News item = this.newsDao.save(convertFromDto(icoItem));
        return convertToDto(item);

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        this.logger.info("delete(id)");
        this.newsDao.delete(id);
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
