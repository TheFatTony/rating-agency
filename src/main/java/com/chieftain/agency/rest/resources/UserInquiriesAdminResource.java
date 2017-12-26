package com.chieftain.agency.rest.resources;

import com.chieftain.agency.dao.userinquiries.UserInquiriesDao;
import com.chieftain.agency.entity.UserInquiries;
import com.chieftain.agency.transfer.UserInquiriesDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/admin/contacts")
public class UserInquiriesAdminResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserInquiriesDao userInquiriesDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserInquiriesDto> list() throws IOException {
        this.logger.info("list()");
        List<UserInquiries> allEntries = this.userInquiriesDao.findAll();
        return allEntries.stream().map(allEntry -> convertToDto(allEntry)).collect(Collectors.toList());
    }

    private UserInquiriesDto convertToDto(UserInquiries userInquiries) {
        UserInquiriesDto userInquiriesDto = modelMapper.map(userInquiries, UserInquiriesDto.class);
        return userInquiriesDto;
    }

}
