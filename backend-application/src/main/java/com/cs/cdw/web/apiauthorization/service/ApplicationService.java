package com.cs.cdw.web.apiauthorization.service;

import com.cs.cdw.web.apiauthorization.error.ErrorBuilder;
import com.cs.cdw.web.apiauthorization.model.Application;
import com.cs.cdw.web.apiauthorization.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAll() {
        return applicationRepository.getAll();
    }

    public Application getApplicationById(String applicationId) {
        return applicationRepository.getById(applicationId).orElseThrow(ErrorBuilder.application_not_found::build);
    }

    public Application create(Application application) {
        application.setId(UUID.randomUUID().toString());
        return applicationRepository.create(application);
    }

    public Application update(Application application) {
        Application persistedApplication = getApplicationById(application.getId());
        persistedApplication.merge(application);
        return applicationRepository.update(persistedApplication);
    }
}

