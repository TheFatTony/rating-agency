package com.chieftain.agency.rest.resources;

import com.chieftain.agency.dao.subscriptions.SubscriptionsDao;
import com.chieftain.agency.entity.Subscriptions;
import com.chieftain.agency.transfer.SubscriptionsDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/subscriptions")
public class SubscriptionsResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private SubscriptionsDao subscriptionsDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SubscriptionsDto create(SubscriptionsDto icoItem) {
        this.logger.info("create(): " + icoItem);
        Subscriptions item = this.subscriptionsDao.save(convertFromDto(icoItem));
        return convertToDto(item);
    }

    private Subscriptions convertFromDto(SubscriptionsDto subscriptionsDto) {
        Subscriptions subscriptions = modelMapper.map(subscriptionsDto, Subscriptions.class);
        return subscriptions;
    }

    private SubscriptionsDto convertToDto(Subscriptions subscriptions) {
        SubscriptionsDto subscriptionsDto = modelMapper.map(subscriptions, SubscriptionsDto.class);
        return subscriptionsDto;
    }

}
