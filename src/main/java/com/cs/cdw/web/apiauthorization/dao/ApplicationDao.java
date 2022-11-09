package com.cs.cdw.web.apiauthorization.dao;

import com.cs.cdw.web.apiauthorization.model.Application;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ApplicationDao {
    @SqlQuery("SELECT * FROM applications")
    @RegisterBeanMapper(Application.class)
    List<Application> getAll();

    @SqlQuery("SELECT * FROM applications WHERE id = :id")
    @RegisterBeanMapper(Application.class)
    Application getById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO applications (id, name, description, status, created_by, updated_by) VALUES (:id, :name, :description, :status, :createdBy, :updatedBy)")
    int create(@BindBean Application application);

    @SqlUpdate("UPDATE applications SET name = :name, description = :description, status = :status, created_by = :createdBy, updated_by = :updatedBy WHERE id = :id")
    int update(@BindBean Application application);
}
