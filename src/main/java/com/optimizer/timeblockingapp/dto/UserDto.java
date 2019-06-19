package com.optimizer.timeblockingapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User DTO", description = "Defines a User by its properties")
public class UserDto {

    @ApiModelProperty(value = "The User's ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "The User's username", example = "John")
    private String username;

    @ApiModelProperty(value = "The User's email", example = "john@doe.com")
    private String email;

    @ApiModelProperty(value = "The User's password", example = "pass123")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}