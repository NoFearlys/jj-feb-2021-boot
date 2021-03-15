package com.lesson3.jjfeb2021.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int taskId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    Client client;
    int quantity;
    String trackNumber;
    String trackNumberOut;
    @Enumerated(EnumType.STRING)
    Status status;

    public Task(){

    }

    public Task(Client client, int quantity, String trackNumber, String trackNumberOut, Status status) {
        this.client = client;
        this.quantity = quantity;
        this.trackNumber = trackNumber;
        this.trackNumberOut = trackNumberOut;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrackNumberOut() {
        return trackNumberOut;
    }

    public void setTrackNumberOut(String trackNumberOut) {
        this.trackNumberOut = trackNumberOut;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
