package com.optimizer.timeblockingapp.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_EVENT_TYPE")
public class EventType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
