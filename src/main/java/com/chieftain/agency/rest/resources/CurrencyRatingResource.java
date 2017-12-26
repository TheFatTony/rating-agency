package com.chieftain.agency.rest.resources;

import com.chieftain.agency.dao.currencyrating.CurrencyRatingDao;
import com.chieftain.agency.entity.CurrencyRating;
import com.chieftain.agency.transfer.CurrencyRatingDto;
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
@Path("/currencies")
public class CurrencyRatingResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyRatingDao currencyRatingDao;

    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CurrencyRatingDto> list() throws IOException {
        this.logger.info("list()");
        List<CurrencyRating> allEntries = this.currencyRatingDao.findAll();
        return allEntries.stream()
                .map(allEntry -> convertToDto(allEntry))
                .collect(Collectors.toList());
    }

    private CurrencyRatingDto convertToDto(CurrencyRating currencyRating) {
        CurrencyRatingDto currencyRatingDto = modelMapper.map(currencyRating, CurrencyRatingDto.class);
        return currencyRatingDto;
    }

}
