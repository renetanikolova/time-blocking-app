package com.optimizer.timeblockingapp.persistence.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Clock;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_ts")
    private LocalDateTime createdTs = LocalDateTime.now(Clock.systemUTC());

    @Column(name = "updated_ts")
    private LocalDateTime updatedTs;

    @Column(name = "created_by_user")
    private String createdByUser;

    @Column(name = "updated_by_user")
    private String updatedByUser;

    public LocalDateTime getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(LocalDateTime createdTs) {
        this.createdTs = createdTs;
    }

    public LocalDateTime getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(LocalDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(String updatedByUser) {
        this.updatedByUser = updatedByUser;
    }
}
