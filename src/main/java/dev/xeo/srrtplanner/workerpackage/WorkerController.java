package dev.xeo.srrtplanner.workerpackage;


import dev.xeo.srrtplanner.entity.Worker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/workers")

public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService theWorkerService) {
       workerService = theWorkerService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listWorkers(Model theModel) {

        // get workers from db
        List<Worker> theWorkers = workerService.findAll();

        // add to the spring model
        theModel.addAttribute("workers", theWorkers);

        return "workers/list-workers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
       Worker theWorker = new Worker();

        theModel.addAttribute("worker", theWorker);

        return "workers/worker-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("workerId") int theId, Model theModel) {

        // get the worker from the service
        Worker theWorker = workerService.findById(theId);

        // set worker as a model attribute to pre-populate the form
        theModel.addAttribute("worker", theWorker);

        // send over to our form
        return "workers/worker-form";
    }


    @PostMapping("/save")
    public String saveWorker(@ModelAttribute("worker")    Worker theWorker) {


        // save theworker
        workerService.save(theWorker);

        // use a redirect to prevent duplicate submissions
        return "redirect:/workers/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("workerId") int theId) {

        // delete the worker
        workerService.deleteById(theId);

        // redirect to /workers/list
        return "redirect:/workers/list";

    }

    @GetMapping("/search")
    public String delete(@RequestParam("workerName") String theName,
                         Model theModel) {

        // delete the worker
        List<Worker> theWorkers = workerService.searchBy(theName);

        // add to the spring model
        theModel.addAttribute("workers", theWorkers);

        // send to workers/list
        return "workers/list-workers";

    }
}
