package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Status;
import com.lesson3.jjfeb2021.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {


    public List<Task> findByStatus(Status status);

    @Query("from Task t where t.client.phone= :clientPhone")
    public List<Task> findByClientPhone(@Param("clientPhone")String clientPhone);

    public List<Task> findByTrackNumber(String trackNumber);
}
