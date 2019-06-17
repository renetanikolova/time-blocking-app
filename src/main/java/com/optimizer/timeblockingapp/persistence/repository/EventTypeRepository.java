package com.optimizer.timeblockingapp.persistence.repository;

import com.optimizer.timeblockingapp.persistence.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {

}
