package com.lesson3.jjfeb2021.controllers;

import com.lesson3.jjfeb2021.models.City;
import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.DAO.ClientDao;
import com.lesson3.jjfeb2021.models.DAO.ModelDao;
import com.lesson3.jjfeb2021.models.DAO.TaskDao;
import com.lesson3.jjfeb2021.models.Status;
import com.lesson3.jjfeb2021.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class MainPage {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ModelDao modelDao;

    @GetMapping("/")
    public String index(Model model){
        List<Task> tasks = taskDao.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }


    @GetMapping("/client{id}")
    public String client(Model model, int id){
        Client client = clientDao.getOne(id);
        model.addAttribute("client", client);
        return "client";
    }

    @GetMapping("/model{id}")
    public String model(Model model, int id){
        com.lesson3.jjfeb2021.models.Model apparatModel = modelDao.getOne(id);
        model.addAttribute("apparatModel", apparatModel);
        return "model";
    }
}
