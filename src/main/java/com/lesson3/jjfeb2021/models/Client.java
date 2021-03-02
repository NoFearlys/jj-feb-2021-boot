package com.lesson3.jjfeb2021.models;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clientId;
    @Column(name = "name")
    String name;
    @Column(name = "city")
    @ManyToOne(cascade = CascadeType.ALL)
    City city;
    @Column(name = "adress")
    String address;
    @Column(name = "phone")
    long phone;
    @Column(name = "name")
    @ManyToOne(cascade = CascadeType.ALL)
    Model model;


    public Client() {

    }

    public Client(String name, City city, String address, long phone, Model model) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.model = model;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
