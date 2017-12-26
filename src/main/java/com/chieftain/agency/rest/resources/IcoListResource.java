package com.chieftain.agency.rest.resources;

import com.chieftain.agency.dao.icolist.IcoListDao;
import com.chieftain.agency.entity.IcoList;
import com.chieftain.agency.transfer.IcoListDto;
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
@Path("/icolist")
public class IcoListResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IcoListDao icoListDao;

    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IcoListDto> list() throws IOException {
        this.logger.info("list()");
        List<IcoList> allEntries = this.icoListDao.findAll();
        return allEntries.stream().map(allEntry -> convertToDto(allEntry)).collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public IcoListDto read(@PathParam("id") Long id) {
        this.logger.info("read(id)");
        IcoList item = this.icoListDao.find(id);
        if (item == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return convertToDto(item);
    }

    private IcoListDto convertToDto(IcoList icoList) {
        IcoListDto icoListDto = modelMapper.map(icoList, IcoListDto.class);
        return icoListDto;
    }

    private IcoList convertFromDto(IcoListDto icoListDto) {
        IcoList icoList = modelMapper.map(icoListDto, IcoList.class);
        return icoList;
    }
}
