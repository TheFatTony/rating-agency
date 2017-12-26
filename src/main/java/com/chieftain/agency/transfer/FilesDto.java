package com.chieftain.agency.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class FilesDto {
    private Long id;

    private String name;

    private String url;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Timestamp effectiveDate;


    public FilesDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
