package dev.xeo.srrtplanner.workerpackage;



import dev.xeo.srrtplanner.entity.Worker;

import java.util.List;

public interface WorkerService {


    List<Worker> findAll();

   Worker findById(int theId);

    void save (Worker theWorker);

    void deleteById(int theId);

    List<Worker> searchBy(String theName);

}
