package com.chieftain.agency.rest.resources;

import com.chieftain.agency.dao.userinquiries.UserInquiriesDao;
import com.chieftain.agency.entity.UserInquiries;
import com.chieftain.agency.transfer.UserInquiriesDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/contacts")
public class UserInquiriesResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserInquiriesDao userInquiriesDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserInquiriesDto create(UserInquiriesDto icoItem) {
        this.logger.info("create(): " + icoItem);
        UserInquiries item = null;
        item = this.userInquiriesDao.save(convertFromDto(icoItem));
        return convertToDto(item);
    }

    private UserInquiries convertFromDto(UserInquiriesDto userInquiriesDto) {
        UserInquiries userInquiries = modelMapper.map(userInquiriesDto, UserInquiries.class);
        return userInquiries;
    }

    private UserInquiriesDto convertToDto(UserInquiries userInquiries) {
        UserInquiriesDto userInquiriesDto = modelMapper.map(userInquiries, UserInquiriesDto.class);
        return userInquiriesDto;
    }

}
