package com.arieltintel.apiworker.service;

import com.arieltintel.apiworker.entities.Worker;
import com.arieltintel.apiworker.exception.WorkerNotFoundException;
import com.arieltintel.apiworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Worker findById(Long id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        return optionalWorker.orElseThrow(() ->
                new WorkerNotFoundException("Trabalhador não encontrado")
        );
    }
}
