package com.cs.cdw.web.apiauthorization.controller;

import com.cs.cdw.web.apiauthorization.model.Api;
import com.cs.cdw.web.apiauthorization.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/application/{application_id}")
    public List<Api> getAllApisByApplicationId(@PathVariable("application_id") String applicationId) {
        return apiService.getAllApisByApplicationId(applicationId);
    }

    @GetMapping("/{id}")
    public Api getById(@PathVariable("id") String applicationId) {
        return apiService.getApiById(applicationId);
    }

    @PutMapping()
    public Api create(@RequestBody Api api) {
        return apiService.create(api);
    }

    @PostMapping()
    public Api update(@RequestBody Api api) {
        return apiService.update(api);
    }
}
