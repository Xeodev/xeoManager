package dev.xeo.srrtplanner.workerpackage;


import dev.xeo.srrtplanner.dao.WorkerRepository;


import dev.xeo.srrtplanner.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {


    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository theWorkerRepository) {
        workerRepository = theWorkerRepository;
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Worker findById(int theId) {
        Optional<Worker> result = workerRepository.findById(theId);

       Worker theWorker = null;

        if (result.isPresent()) {
            theWorker = result.get();
        } else {
            // we didn't find the worker
            throw new RuntimeException("Did not find worker id - " + theId);
        }

        return theWorker;
    }

    @Override
    public void save(Worker theWorker) {
        workerRepository.save(theWorker);
    }

    @Override
    public void deleteById(int theId) {
        workerRepository.deleteById(theId);
    }

    @Override
    public List<Worker> searchBy(String theName) {

        List<Worker> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = workerRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
        } else {
            results = findAll();
        }

        return results;
    }

}
