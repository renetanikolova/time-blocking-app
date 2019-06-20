package com.optimizer.timeblockingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when user input is invalid or incomplete.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public InvalidInputException(String message) {
        super(message);
    }

}
