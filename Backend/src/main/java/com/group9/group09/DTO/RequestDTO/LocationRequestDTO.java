package com.group9.group09.DTO.RequestDTO;

import java.time.LocalDateTime;

public class LocationRequestDTO extends RequestDTO {

    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
