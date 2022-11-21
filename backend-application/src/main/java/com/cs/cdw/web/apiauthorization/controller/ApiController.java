package com.cs.cdw.web.apiauthorization.controller;

import com.cs.cdw.web.apiauthorization.model.Api;
import com.cs.cdw.web.apiauthorization.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/application/{application_id}")
    public ResponseEntity<List<Api>> getAllApisByApplicationId(@PathVariable("application_id") String applicationId) {
        return ResponseEntity.ok(apiService.getAllApisByApplicationId(applicationId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Api> getById(@PathVariable("id") String applicationId) {
        return ResponseEntity.ok(apiService.getApiById(applicationId));
    }

    @PutMapping()
    public ResponseEntity<Api> create(@RequestBody Api api) {
        return ResponseEntity.ok(apiService.create(api));
    }

    @PostMapping()
    public ResponseEntity<Api> update(@RequestBody Api api) {
        return ResponseEntity.ok(apiService.update(api));
    }
}
