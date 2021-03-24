package com.lesson3.jjfeb2021.models;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int modelId;
    String name;
    String version;
    int price;
    String dataRegister;
    String dataContent;

    public Model(){

    }

    public Model(String name, String version, int price, String dataRegister, String dataContent) {
        this.name = name;
        this.version = version;
        this.price = price;
        this.dataRegister = dataRegister;
        this.dataContent = dataContent;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDataRegister() {
        return dataRegister;
    }

    public void setDataRegister(String dataRegister) {
        this.dataRegister = dataRegister;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }
}
