package com.cs.cdw.web.apiauthorization.model;

import com.cs.cdw.web.apiauthorization.constant.ApplicationStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Data
public class Application extends BaseEntity<Application> {
    private String id;
    private String name;
    private String description;
    private ApplicationStatus status;

    @Override
    public void merge(Application entity) {
        if (StringUtils.isNotBlank(entity.name)) {
            this.name = entity.name;
        }

        if (StringUtils.isNotBlank(entity.description)) {
            this.description = entity.description;
        }

        if (Objects.nonNull(entity.status)) {
            this.status = entity.status;
        }
    }
}
