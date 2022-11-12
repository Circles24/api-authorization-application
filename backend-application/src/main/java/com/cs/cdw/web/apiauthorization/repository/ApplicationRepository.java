package com.cs.cdw.web.apiauthorization.repository;

import com.cs.cdw.web.apiauthorization.dao.ApplicationDao;
import com.cs.cdw.web.apiauthorization.error.ErrorBuilder;
import com.cs.cdw.web.apiauthorization.model.Application;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationRepository {
    @Autowired
    private Jdbi jdbi;

    public List<Application> getAll() {
        return jdbi.withExtension(ApplicationDao.class, ApplicationDao::getAll);
    }

    public Optional<Application> getById(String applicationId) {
        return Optional.ofNullable(jdbi.withExtension(ApplicationDao.class, dao->dao.getById(applicationId)));
    }

    public Application create(Application application) {
        jdbi.withExtension(ApplicationDao.class, dao->dao.create(application));
        return getById(application.getId()).orElseThrow(ErrorBuilder.application_not_found::build);
    }

    public Application update(Application application) {
        jdbi.withExtension(ApplicationDao.class, dao->dao.update(application));
        return getById(application.getId()).orElseThrow(ErrorBuilder.application_not_found::build);
    }
}
