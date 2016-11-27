package com.korgutlova.entities;

public class Community {
    private long id;
    private String name;
    private String description;
    private long founderId;
    private java.sql.Date createdAt;

    public Community(long id, String name, String description, long founderId, java.sql.Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.founderId = founderId;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFounderId() {
        return founderId;
    }

    public void setFounderId(long founderId) {
        this.founderId = founderId;
    }

    public java.sql.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", founderId=" + founderId +
                ", createdAt=" + createdAt +
                '}';
    }
}
