package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {


    public List<Client> findByName(String name);

    @Query("from Client c where c.city.name= :cityName")
    public List<Client> findByCityName(@Param("cityName") String cityName);

    @Query("from Client c where c.model.name= :modelName")
    public List<Client> findByModelName(@Param("modelName") String modelName);
}
