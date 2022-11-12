package com.cs.cdw.web.apiauthorization.dao;

import com.cs.cdw.web.apiauthorization.model.Api;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ApiDao {
    @SqlQuery("SELECT * FROM apis WHERE id = :id")
    @RegisterBeanMapper(Api.class)
    Api getById(@Bind("id") String id);

    @SqlQuery("SELECT * FROM apis WHERE application_id = :application_id")
    @RegisterBeanMapper(Api.class)
    List<Api> getAllByApplicationId(@Bind("application_id") String applicationId);

    @SqlUpdate("INSERT INTO apis (id, name, description, status, application_id, endpoint, mandatory_query_params, optional_query_params, response_format, service_id, created_by, updated_by) VALUES (:id, :name, :description, :status, :applicationId, :endpoint, :mandatoryQueryParams, :optionalQueryParams, :responseFormat, :serviceId, :createdBy, :updatedBy)")
    int create(@BindBean Api api);

    @SqlUpdate("UPDATE apis SET name = :name, description = :description, status = :status, application_id = :applicationId, endpoint = :endpoint, mandatory_query_params = :mandatoryQueryParams, optional_query_params = :optionalQueryParams, response_format = :responseFormat, service_id = :serviceId, created_by = :createdBy, updated_by = :updatedBy WHERE id = :id")
    int update(@BindBean Api api);
}
