package com.chieftain.agency.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "ico_list")
public class IcoList implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private java.sql.Timestamp startDate;

    @Column
    private java.sql.Timestamp endDate;

    @Column
    private String website;


    public IcoList() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate != null)
            this.startDate = new Timestamp(startDate.getTime());
    }

    public java.sql.Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(java.sql.Timestamp endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(Date endDate) {
        if (endDate != null)
            this.endDate = new Timestamp(endDate.getTime());
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
