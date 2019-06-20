package com.optimizer.timeblockingapp.service;

import com.optimizer.timeblockingapp.dto.UserDto;
import com.optimizer.timeblockingapp.exception.InvalidInputException;
import com.optimizer.timeblockingapp.persistence.entity.User;
import com.optimizer.timeblockingapp.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.optimizer.timeblockingapp.utils.ModelMapperConverter.convertList;
import static com.optimizer.timeblockingapp.utils.ModelMapperConverter.convertObject;
import static com.optimizer.timeblockingapp.utils.ValidationUtils.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUser(Optional<Long> id) {
        if (id.isPresent()) {
            User user = userRepository.findById(id.get()).orElseThrow(() -> new InvalidInputException("User with such an ID does not exist."));
            return new ArrayList<>(Arrays.asList(convertObject(user, UserDto.class)));
        } else {
            List<User> users = userRepository.findAll();
            return convertList(users, UserDto.class);
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        nullCheck(userDto.getUsername(), "username");
        validateShortString(userDto.getUsername(), "username");
        Optional<User> usernameExists = userRepository.findUserByUsername(userDto.getUsername());
        if (usernameExists.isPresent()) {
            throw new InvalidInputException("The provided username already exists!");
        }

        nullCheck(userDto.getEmail(), "email");
        validateShortString(userDto.getEmail(), "email");
        Optional<User> emailExists = userRepository.findUserByEmail(userDto.getEmail());
        if (emailExists.isPresent()) {
            throw new InvalidInputException("The provided email already exists!");
        }


        nullCheck(userDto.getPassword(), "password");
        validateShortString(userDto.getPassword(), "password");

//        if (!userDto.getPassword().equals(userDto.getRePassword())) {
//            throw new InvalidInputException("Both passwords do not match!");
//        }

        nullCheck(userDto.getRePassword(), "confirmation password");
        validateLongString(userDto.getRePassword(), "confirmation password");

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        // set ROLE

        user = userRepository.save(user);

        return convertObject(user, UserDto.class);
    }
}
