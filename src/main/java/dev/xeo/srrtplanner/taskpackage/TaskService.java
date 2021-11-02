package dev.xeo.srrtplanner.taskpackage;


import dev.xeo.srrtplanner.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

   Task findById(int theId);

    void save(Task theTask);

    void deleteById(int theId);

    List<Task> searchBy(String theName);
}
