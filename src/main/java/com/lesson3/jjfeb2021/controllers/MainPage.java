package com.lesson3.jjfeb2021.controllers;

import com.lesson3.jjfeb2021.models.DAO.TaskDao;
import com.lesson3.jjfeb2021.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage {

    @Autowired
    private TaskDao taskDao;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Task> tasks = taskDao.findAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }
}
