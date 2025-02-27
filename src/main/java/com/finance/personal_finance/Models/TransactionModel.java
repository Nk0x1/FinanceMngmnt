package com.finance.personal_finance.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("transId")
    private int transId;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("transType")
    private String transType;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("category")
    private String category;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date dot = new Date();

    @JsonProperty("notes")
    private String notes;

    public TransactionModel() {
    }

    public TransactionModel(int id, int transId, int userId, String transType, int amount, String category, Date dot, String notes) {
        this.id = id;
        this.transId = transId;
        this.userId = userId;
        this.transType = transType;
        this.amount = amount;
        this.category = category;
        this.dot = dot;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDot() {
        return dot;
    }

    public void setDot(Date dot) {
        this.dot = dot;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @PrePersist
    protected void onCreate() {
        this.dot = new Date();
    }
}
