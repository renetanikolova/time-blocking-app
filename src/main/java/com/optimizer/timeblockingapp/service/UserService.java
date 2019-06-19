package com.optimizer.timeblockingapp.service;

import com.optimizer.timeblockingapp.dto.UserDto;

import java.util.Optional;

public interface UserService {

    UserDto getUser(Optional<Long> id);

    UserDto createUser(UserDto userDto);

}
