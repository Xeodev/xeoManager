package dev.xeo.srrtplanner.dao;


import dev.xeo.srrtplanner.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


    // add a method to sort by task name
    List<Task> findAllByOrderByTaskNameAsc();

    // search by name
    List<Task> findByTaskNameContainsOrDescriptionContainsAllIgnoreCase(String name, String lName);

}

