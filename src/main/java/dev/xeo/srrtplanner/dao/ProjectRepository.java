package dev.xeo.srrtplanner.dao;


import dev.xeo.srrtplanner.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {



        // add a method to sort by project name
        List<Project> findAllByOrderByProjectNameAsc();

        // search by name
        List<Project> findByProjectNameContainsOrDescriptionContainsAllIgnoreCase(String name, String lName);
}
