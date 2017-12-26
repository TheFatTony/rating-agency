package com.chieftain.agency.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;


public class UserInquiriesDto {

    private Long id;

    @JsonFormat(pattern = "dd/mm/yyy")
    private Timestamp effectiveDate;

    private String name;

    private String email;

    private String comment;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
