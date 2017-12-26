package com.chieftain.agency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IcoAlertEntity {


    @JsonProperty("DaysTillEnd")
    private Integer daysTillEnd;
    private String category;
    private String recent;
    private String description;
    private Date endDate;
    private String featuredListing;
    private String icoID;
    private String reportAvailable;
    private String reportLink;
    private Date startDate;
    private String startDay;
    private String startMonth;
    private String tbd;
    private String title;
    private String website;

    public Integer getDaysTillEnd() {
        return daysTillEnd;
    }

    public void setDaysTillEnd(Integer daysTillEnd) {
        this.daysTillEnd = daysTillEnd;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecent() {
        return recent;
    }

    public void setRecent(String recent) {
        this.recent = recent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFeaturedListing() {
        return featuredListing;
    }

    public void setFeaturedListing(String featuredListing) {
        this.featuredListing = featuredListing;
    }

    public String getIcoID() {
        return icoID;
    }

    public void setIcoID(String icoID) {
        this.icoID = icoID;
    }

    public String getReportAvailable() {
        return reportAvailable;
    }

    public void setReportAvailable(String reportAvailable) {
        this.reportAvailable = reportAvailable;
    }

    public String getReportLink() {
        return reportLink;
    }

    public void setReportLink(String reportLink) {
        this.reportLink = reportLink;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getTbd() {
        return tbd;
    }

    public void setTbd(String tbd) {
        this.tbd = tbd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
