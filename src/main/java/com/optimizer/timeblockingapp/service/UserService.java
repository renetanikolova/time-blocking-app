package com.optimizer.timeblockingapp.service;

import com.optimizer.timeblockingapp.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Returns a user with its data if the user ID is provided and valid.
     * If the ID is invalid -> throws an exception.
     * If the ID is not provided -> returns list of all users.
     *
     * @param id
     * @return
     */
    List<UserDto> getUser(Optional<Long> id);

    /**
     * Creates a user with username, password, re-password, email.
     * Validation: checks if all the fields are provided,
     * and if the username is not taken - if so, throws an exception.
     *
     * @param userDto
     * @return
     */
    UserDto createUser(UserDto userDto);

}
