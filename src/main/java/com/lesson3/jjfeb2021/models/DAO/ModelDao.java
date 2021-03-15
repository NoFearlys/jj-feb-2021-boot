package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelDao  extends JpaRepository<Model, Integer> {

    List<Model> findByVersion(String version);

    List<Model> findByName(String name);

}
