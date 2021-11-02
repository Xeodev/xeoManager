package dev.xeo.srrtplanner.dao;

import dev.xeo.srrtplanner.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {




    // add a method to sort by last name
    List<Worker> findAllByOrderByLastNameAsc();

    // search by name
    List<Worker> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
