package com.korgutlova.entities;

import java.sql.Timestamp;

public class News {
    private long id;
    private String text;
    private long communityId;
    private long authorId;
    private java.sql.Timestamp createdAt;

    public News(long id, String text, long communityId, long authorId, Timestamp createdAt) {
        this.id = id;
        this.text = text;
        this.communityId = communityId;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", communityId=" + communityId +
                ", authorId=" + authorId +
                ", createdAt=" + createdAt +
                '}';
    }
}
