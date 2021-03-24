package com.lesson3.jjfeb2021.controllers;

import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.DAO.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/client/")
public class RestClientController {

    @Autowired
    private ClientDao clientDao;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Client getClient (@PathVariable int id){
        try{
            return clientDao.findById(id).get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
