package com.korgutlova.entities;


import java.sql.Timestamp;

public class Message {
    private long id;
    private String text;
    private long senderId;
    private long recipientId;
    private Timestamp createdAt;
    private String status;

    public Message(String text, long senderId, long recipientId, java.sql.Timestamp createdAt, String status) {
        this.text = text;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.createdAt = createdAt;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
