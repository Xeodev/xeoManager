package dev.xeo.srrtplanner.projectpackage;


import dev.xeo.srrtplanner.entity.Project;

import java.util.List;

public interface ProjectService {

        List<Project> findAll();

        Project findById(int theId);

        void save(Project theProject);

        void deleteById(int theId);

        List<Project> searchBy(String theName);
}
