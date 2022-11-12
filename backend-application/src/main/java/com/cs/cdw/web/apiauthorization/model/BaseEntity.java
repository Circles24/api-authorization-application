package com.cs.cdw.web.apiauthorization.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public abstract class BaseEntity<T extends BaseEntity> {
    Timestamp createdAt;
    String createdBy;
    Timestamp updatedAt;
    String updatedBy;

    public abstract void merge(T entity);
}
