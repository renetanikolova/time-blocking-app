package com.optimizer.timeblockingapp.controller;

import com.optimizer.timeblockingapp.dto.UserDto;
import com.optimizer.timeblockingapp.service.UserServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/user")
@Api(tags = "Apps: User")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @ApiOperation(
            value = "Retrieve single User",
            produces = "application/json",
            response = UserDto.class
    )
    @GetMapping(path = "/{id}")
    @ResponseBody
    public UserDto getUser(@ApiParam(value = "The ID of the requested User") @PathVariable(value = "id") Optional<Long> id) {
        return userService.getUser(id);
    }
    

}
