package dev.xeo.srrtplanner.taskpackage;


import dev.xeo.srrtplanner.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService theTaskService) {
        taskService = theTaskService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listTasks(Model theModel) {

        // get tasks from db
        List<Task> theTasks = taskService.findAll();

        // add to the spring model
        theModel.addAttribute("tasks", theTasks);

        return "tasks/list-tasks";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Task theTask = new Task();

        theModel.addAttribute("task", theTask);

        return "tasks/task-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") int theId,
                                    Model theModel) {

        // get the task from the service
        Task theTask = taskService.findById(theId);

        // set task as a model attribute to pre-populate the form
        theModel.addAttribute("task", theTask);

        // send over to our form
        return "tasks/task-form";
    }


    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task theTask) {

        // save the task
        taskService.save(theTask);

        // use a redirect to prevent duplicate submissions
        return "redirect:/tasks/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") int theId) {

        // delete the task
        taskService.deleteById(theId);

        // redirect to /tasks/list
        return "redirect:/tasks/list";

    }

    @GetMapping("/search")
    public String delete(@RequestParam("taskName") String theName,
                         Model theModel) {

        // delete the task
        List<Task> theTasks = taskService.searchBy(theName);

        // add to the spring model
        theModel.addAttribute("tasks", theTasks);

        // send to /tasks/list
        return "tasks/list-tasks";

    }

}














