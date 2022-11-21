package com.cs.cdw.web.apiauthorization.controller;

import com.cs.cdw.web.apiauthorization.model.Application;
import com.cs.cdw.web.apiauthorization.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping()
    public ResponseEntity<List<Application>> getAllApisByApplicationId() {
        return ResponseEntity.ok(applicationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getById(@PathVariable("id") String applicationId) {
        return ResponseEntity.ok(applicationService.getApplicationById(applicationId));
    }

    @PutMapping()
    public ResponseEntity<Application> create(@RequestBody Application application) {
        return ResponseEntity.ok(applicationService.create(application));
    }

    @PostMapping()
    public ResponseEntity<Application> update(@RequestBody Application application) {
        return ResponseEntity.ok(applicationService.update(application));
    }
}

