package com.optimizer.timeblockingapp.persistence.repository;

import com.optimizer.timeblockingapp.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
