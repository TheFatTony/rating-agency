package com.chieftain.agency.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@javax.persistence.Entity
@Table(name="files")
public class Files implements Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column(name = "effective_date")
	private Timestamp effectiveDate;

	@Column
	private String url;


	public Files() {
		effectiveDate = new Timestamp(System.currentTimeMillis());
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

	public void setUrl() {
		this.url = "rest/files/download/" + getId().toString();
	}
	public Timestamp getEffectiveDate() {
		return effectiveDate;
	}

}
