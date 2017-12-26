package com.chieftain.agency.rest.resources;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.chieftain.agency.aws.S3Wrapper;
import com.chieftain.agency.dao.files.FilesDao;
import com.chieftain.agency.entity.Files;
import com.chieftain.agency.transfer.FilesDto;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/admin/files")
public class FilesAdminResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FilesDao filesDao;

    @Autowired
    private S3Wrapper s3Wrapper;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${use.amazon.aws}")
    private boolean useAWS;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilesDto> list() throws IOException {
        this.logger.info("list()");
        List<Files> allEntries = this.filesDao.findAll();
        return allEntries.stream().map(allEntry -> convertToDto(allEntry)).collect(Collectors.toList());
    }

    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadFile(@FormDataParam("content") InputStream fileInputStream,
                               @FormDataParam("content") FormDataContentDisposition fileMetaData) throws Exception {
        Files item = new Files();
        item.setName(fileMetaData.getFileName());
        item = this.filesDao.save(item);
        item.setUrl();
        this.filesDao.save(item);

        if (useAWS) {
            PutObjectResult putObjectResult =
                    s3Wrapper.upload(fileInputStream, item.getId().toString());
        } else {
            OutputStream os = new FileOutputStream(System.getProperty("java.io.tmpdir")+item.getId().toString());
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = fileInputStream.read(buffer)) !=-1){
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
            os.close();
        }

        return Response.ok("Data uploaded successfully !!").build();
    }

    private FilesDto convertToDto(Files files) {
        FilesDto filesDto = modelMapper.map(files, FilesDto.class);
        return filesDto;
    }

    private Files convertFromDto(FilesDto filesDto) {
        Files files = modelMapper.map(filesDto, Files.class);
        return files;
    }

}
