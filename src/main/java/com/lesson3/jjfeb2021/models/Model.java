package com.lesson3.jjfeb2021.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue
    int modelId;
    String name;
    String version;
    int price;
    String dataRegister;
    String data_content;

    public Model(){

    }

    public Model(String name, String version, int price, String dataRegister, String data_content) {
        this.name = name;
        this.version = version;
        this.price = price;
        this.dataRegister = dataRegister;
        this.data_content = data_content;
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

    public String getData_content() {
        return data_content;
    }

    public void setData_content(String data_content) {
        this.data_content = data_content;
    }
}
