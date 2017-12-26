package com.chieftain.agency.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@javax.persistence.Entity
@Table(name = "user_inquiries")
public class UserInquiries implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "effective_date")
    private Timestamp effectiveDate;


    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String comment;


    public UserInquiries() {
        effectiveDate = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
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
