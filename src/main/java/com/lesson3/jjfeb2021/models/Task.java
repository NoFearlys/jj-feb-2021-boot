package com.lesson3.jjfeb2021.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int taskId;
    @ManyToOne
    Client client;
    int quantity;
    long trackNumberIn;
    long trackNumberOut;
    @Enumerated(EnumType.STRING)
    Status status;

    public Task(){

    }

    public Task(Client client, int quantity, long trackNumberIn, long trackNumberOut, Status status) {
        this.client = client;
        this.quantity = quantity;
        this.trackNumberIn = trackNumberIn;
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

    public long getTrackNumberIn() {
        return trackNumberIn;
    }

    public void setTrackNumberIn(long trackNumberIn) {
        this.trackNumberIn = trackNumberIn;
    }

    public long getTrackNumberOut() {
        return trackNumberOut;
    }

    public void setTrackNumberOut(long trackNumberOut) {
        this.trackNumberOut = trackNumberOut;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
