package dev.xeo.srrtplanner.projectpackage;


import dev.xeo.srrtplanner.dao.ProjectRepository;
import dev.xeo.srrtplanner.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

        private final ProjectRepository projectRepository;

        @Autowired
        public ProjectServiceImpl(ProjectRepository theProjectRepository) {
            projectRepository = theProjectRepository;
        }

        @Override
        public List<Project> findAll() {
            return projectRepository.findAllByOrderByProjectNameAsc();
        }

        @Override
        public Project findById(int theId) {
            Optional<Project> result = projectRepository.findById(theId);

           Project theProject = null;

            if (result.isPresent()) {
                theProject = result.get();
            }
            else {
                // we didn't find the project
                throw new RuntimeException("Did not find project id - " + theId);
            }

            return theProject;
        }

        @Override
        public void save(Project theProject) {
            projectRepository.save(theProject);
        }

        @Override
        public void deleteById(int theId) {
            projectRepository.deleteById(theId);
        }

        @Override
        public List<Project> searchBy(String theName) {

            List<Project> results = null;

            if (theName != null && (theName.trim().length() > 0)) {
                results = projectRepository.findByProjectNameContainsOrDescriptionContainsAllIgnoreCase(theName, theName);
            }
            else {
                results = findAll();
            }

            return results;
        }

    }
