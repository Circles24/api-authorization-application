package com.cs.cdw.web.apiauthorization.controller;

import com.cs.cdw.web.apiauthorization.model.Application;
import com.cs.cdw.web.apiauthorization.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping()
    public List<Application> getAllApisByApplicationId() {
        return applicationService.getAll();
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable("id") String applicationId) {
        return applicationService.getApplicationById(applicationId);
    }

    @PutMapping()
    public Application create(@RequestBody Application application) {
        return applicationService.create(application);
    }

    @PostMapping()
    public Application update(@RequestBody Application application) {
        return applicationService.update(application);
    }
}

