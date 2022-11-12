package com.cs.cdw.web.apiauthorization.repository;

import com.cs.cdw.web.apiauthorization.dao.ApiDao;
import com.cs.cdw.web.apiauthorization.error.ErrorBuilder;
import com.cs.cdw.web.apiauthorization.model.Api;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ApiRepository {
    @Autowired
    private Jdbi jdbi;

    public List<Api> getAllByApplicationId(String applicationId) {
        return jdbi.withExtension(ApiDao.class, dao->dao.getAllByApplicationId(applicationId));
    }

    public Optional<Api> getById(String apiId) {
        return Optional.ofNullable(jdbi.withExtension(ApiDao.class, dao->dao.getById(apiId)));
    }

    public Api create(Api api) {
        jdbi.withExtension(ApiDao.class, dao->dao.create(api));
        return getById(api.getId()).orElseThrow(ErrorBuilder.api_not_found::build);
    }

    public Api update(Api api) {
        jdbi.withExtension(ApiDao.class, dao->dao.update(api));
        return getById(api.getId()).orElseThrow(ErrorBuilder.api_not_found::build);
    }
}

