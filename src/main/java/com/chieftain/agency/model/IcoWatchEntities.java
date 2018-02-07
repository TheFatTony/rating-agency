package com.chieftain.agency.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "ico")
public class IcoWatchEntities {

    List<IcoWatchEntity> live;

    List<IcoWatchEntity> upcoming;

    List<IcoWatchEntity> finished;

    public List<IcoWatchEntity> getLive() {
        return live;
    }

    public void setLive(List<IcoWatchEntity> live) {
        this.live = live;
    }

    public List<IcoWatchEntity> getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(List<IcoWatchEntity> upcoming) {
        this.upcoming = upcoming;
    }

    public List<IcoWatchEntity> getFinished() {
        return finished;
    }

    public void setFinished(List<IcoWatchEntity> finished) {
        this.finished = finished;
    }
}
