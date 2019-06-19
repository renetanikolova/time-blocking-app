package com.optimizer.timeblockingapp.service;

import com.optimizer.timeblockingapp.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto getUser(Optional<Long> id) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }
}
