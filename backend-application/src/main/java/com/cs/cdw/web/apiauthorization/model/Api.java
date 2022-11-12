package com.cs.cdw.web.apiauthorization.model;

import com.cs.cdw.web.apiauthorization.constant.ApiResponseFormat;
import com.cs.cdw.web.apiauthorization.constant.ApiStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Data
public class Api extends BaseEntity<Api> {
    private String id;
    private String name;
    private String description;
    private ApiStatus status;
    private String applicationId;
    private String endpoint;
    private String mandatoryQueryParams;
    private String optionalQueryParams;
    private ApiResponseFormat responseFormat;
    private String serviceId;

    @Override
    public void merge(Api entity) {
        if (StringUtils.isNotBlank(entity.name)) {
            this.name = entity.name;
        }

        if (StringUtils.isNotBlank(entity.description)) {
            this.description = entity.description;
        }

        if (Objects.nonNull(entity.status)) {
            this.status = entity.status;
        }

        if (Objects.nonNull(entity.applicationId)) {
            this.applicationId = entity.applicationId;
        }

        if (StringUtils.isNotBlank(entity.endpoint)) {
            this.endpoint = entity.endpoint;
        }

        if (StringUtils.isNotBlank(entity.mandatoryQueryParams)) {
            this.mandatoryQueryParams = entity.mandatoryQueryParams;
        }

        if (StringUtils.isNotBlank(entity.optionalQueryParams)) {
            this.optionalQueryParams = entity.optionalQueryParams;
        }

        if (Objects.nonNull(entity.responseFormat)) {
            this.responseFormat = entity.responseFormat;
        }

        if (StringUtils.isNotBlank(entity.serviceId)) {
            this.serviceId = entity.serviceId;
        }
    }
}
