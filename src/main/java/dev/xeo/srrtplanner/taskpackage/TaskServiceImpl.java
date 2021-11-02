package dev.xeo.srrtplanner.taskpackage;

import dev.xeo.srrtplanner.dao.TaskRepository;
import dev.xeo.srrtplanner.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository theTaskRepository) {
        taskRepository = theTaskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAllByOrderByTaskNameAsc();
    }

    @Override
    public Task findById(int theId) {
        Optional<Task> result = taskRepository.findById(theId);

        Task theTask = null;

        if (result.isPresent()) {
            theTask = result.get();
        } else {
            // we didn't find the task
            throw new RuntimeException("Did not find task id - " + theId);
        }

        return theTask;
    }

    @Override
    public void save(Task theTask) {
        taskRepository.save(theTask);
    }

    @Override
    public void deleteById(int theId) {
        taskRepository.deleteById(theId);
    }

    @Override
    public List<Task> searchBy(String theName) {

        List<Task> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = taskRepository.findByTaskNameContainsOrDescriptionContainsAllIgnoreCase(theName, theName);
        } else {
            results = findAll();
        }

        return results;
    }

}
