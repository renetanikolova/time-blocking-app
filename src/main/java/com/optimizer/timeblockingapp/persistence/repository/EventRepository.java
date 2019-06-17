package com.optimizer.timeblockingapp.persistence.repository;

import com.optimizer.timeblockingapp.persistence.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
