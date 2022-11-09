package com.cs.cdw.web.apiauthorization.service;

import com.cs.cdw.web.apiauthorization.error.ErrorBuilder;
import com.cs.cdw.web.apiauthorization.model.Api;
import com.cs.cdw.web.apiauthorization.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApiService {
    @Autowired
    private ApiRepository apiRepository;

    public List<Api> getAllApisByApplicationId(String applicationId) {
        return apiRepository.getAllByApplicationId(applicationId);
    }

    public Api getApiById(String apiId) {
        return apiRepository.getById(apiId).orElseThrow(ErrorBuilder.api_not_found::build);
    }

    public Api create(Api api) {
        api.setId(UUID.randomUUID().toString());
        return apiRepository.create(api);
    }

    public Api update(Api api) {
        Api persistedApi = getApiById(api.getId());
        persistedApi.merge(api);
        return apiRepository.update(persistedApi);
    }
}
