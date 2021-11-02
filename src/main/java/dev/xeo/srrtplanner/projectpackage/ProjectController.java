package dev.xeo.srrtplanner.projectpackage;

import dev.xeo.srrtplanner.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/projects")
public class ProjectController {

        private final ProjectService projectService;

        public ProjectController(ProjectService theProjectService) {
           projectService = theProjectService;
        }

        // add mapping for "/list"

        @GetMapping("/list")
        public String listProjects(Model theModel) {

            // get projects from db
            List<Project> theProjects = projectService.findAll();

            // add to the spring model
            theModel.addAttribute("projects", theProjects);

            return "projects/list-projects";
        }

        @GetMapping("/showFormForAdd")
        public String showFormForAdd(Model theModel) {

            // create model attribute to bind form data
            Project theProject = new Project();

            theModel.addAttribute("project", theProject);

            return "projects/project-form";
        }

        @GetMapping("/showFormForUpdate")
        public String showFormForUpdate(@RequestParam("projectId") int theId,
                                        Model theModel) {

            // get the project from the service
            Project theProject = projectService.findById(theId);

            // set project as a model attribute to pre-populate the form
            theModel.addAttribute("project", theProject);

            // send over to our form
            return "projects/project-form";
        }


    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project theProject) {

        // save the project
        projectService.save(theProject);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/list";
    }


        @GetMapping("/delete")
        public String delete(@RequestParam("projectId") int theId) {

            // delete the project
           projectService.deleteById(theId);

            // redirect to /projects/list
            return "redirect:/projects/list";

        }

        @GetMapping("/search")
        public String delete(@RequestParam("projectName") String theName,
                             Model theModel) {

            // delete the project
            List<Project> theProjects = projectService.searchBy(theName);

            // add to the spring model
            theModel.addAttribute("projects", theProjects);

            // send to /projects/list
            return "projects/list-projects";

        }

    }




















