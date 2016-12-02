package com.korgutlova.entities;


import java.sql.Timestamp;

public class Request {
    private long id;
    private long needyId;
    private long volunteerId;
    private String address;
    private double latitude;
    private double longitude;
    private Timestamp createdAt;
    private String serviceType;
    private String status;

    public Request(long needyId, long volunteerId, String address, double latitude, double longitude, Timestamp createdAt, String serviceType, String status) {
        this.needyId = needyId;
        this.volunteerId = volunteerId;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.serviceType = serviceType;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getNeedyId() {
        return needyId;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setNeedyId(long needyId) {
        this.needyId = needyId;
    }

    public void setVolunteerId(long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
