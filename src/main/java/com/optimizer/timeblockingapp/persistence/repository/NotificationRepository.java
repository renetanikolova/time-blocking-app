package com.optimizer.timeblockingapp.persistence.repository;

import com.optimizer.timeblockingapp.persistence.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
