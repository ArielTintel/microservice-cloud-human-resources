package com.arieltintel.apiworker.controller;

import com.arieltintel.apiworker.entities.Worker;
import com.arieltintel.apiworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RefreshScope
@RestController
@RequestMapping("v1/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final Environment environment;

    private final WorkerService workerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAll() {
        return workerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Worker findById(@PathVariable Long id) {

        //Simulate an Timeout Exception
        /*try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        log.info("PORT -> -> -> " + environment.getProperty("local.server.port"));
        return workerService.findById(id);
    }

}
