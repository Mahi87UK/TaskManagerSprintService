package com.example.repository;

import com.example.model.ParentTask;
import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface TaskRepo extends JpaRepository <Task, Integer> {

    @Query(value = "SELECT p FROM ParentTask p where p.parentTaskName =?1")
    ParentTask findParentTaskByName(String parentTaskName);

}
