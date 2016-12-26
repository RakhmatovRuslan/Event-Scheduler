package org.bileton.ticketing;

import java.sql.Timestamp;

/**
 * Created by Ruslan on 12/26/2016.
 */
public class EventScheduler {
    private Integer id;
    private Timestamp date;
    private Boolean isActivation;
    private Integer eventStatus;
    private Integer eventId;

    public EventScheduler() {
    }

    public EventScheduler(Integer id, Timestamp date, Boolean isActivation, Integer eventStatus, Integer eventId) {
        this.id = id;
        this.date = date;
        this.isActivation = isActivation;
        this.eventStatus = eventStatus;
        this.eventId = eventId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getActivation() {
        return isActivation;
    }

    public void setActivation(Boolean activation) {
        isActivation = activation;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "EventScheduler{" +
                "id=" + id +
                ", date=" + date +
                ", isActivation=" + isActivation +
                ", eventStatus=" + eventStatus +
                ", eventId=" + eventId +
                '}';
    }
}
