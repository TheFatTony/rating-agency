package com.chieftain.agency.rest.resources;

import com.chieftain.agency.aws.S3Wrapper;
import com.chieftain.agency.dao.files.FilesDao;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@Path("/files")
public class FilesResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FilesDao filesDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private S3Wrapper s3Wrapper;

    @Value("${use.amazon.aws}")
    private boolean useAWS;

    @GET
    @Path("/download/{id}")
    public Response downloadFile(@PathParam("id") Long id) {

        com.chieftain.agency.entity.Files itemDb = this.filesDao.find(id);

        if (useAWS) {
            try {
                ResponseEntity<byte[]> items = s3Wrapper.download(id.toString());
                return Response.ok(items.getBody(), MediaType.APPLICATION_OCTET_STREAM)
                        .header("content-disposition", "attachment; filename = " + itemDb.getName()).build();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            try {
                return Response.ok(Files.readAllBytes(new File(System.getProperty("java.io.tmpdir") + itemDb.getId().toString()).toPath()), MediaType.APPLICATION_OCTET_STREAM)
                        .header("content-disposition", "attachment; filename = " + itemDb.getName()).build();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
    }

}
