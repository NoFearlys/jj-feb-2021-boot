package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityDao extends JpaRepository<City, Integer> {

    public List<City> findByName(String name);

}
