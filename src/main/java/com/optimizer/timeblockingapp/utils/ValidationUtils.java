package com.optimizer.timeblockingapp.utils;

import com.optimizer.timeblockingapp.exception.InvalidInputException;
import org.springframework.util.StringUtils;

public class ValidationUtils {

    private static final int TINY_STRING_MAX_LENGTH = 32;
    private static final int SHORT_STRING_MAX_LENGTH = 64;
    private static final int MID_STRING_MAX_LENGTH = 128;
    private static final int LONG_STRING_MAX_LENGTH = 256;

    public static boolean isNullOrEmpty(String input) {
        return input == null || StringUtils.isEmpty(input);
    }

    public static void nullCheck(String fieldValue, String fieldName) {
        if (isNullOrEmpty(fieldValue)) {
            String message = String.format("The %s is required!", fieldName);
            throw new InvalidInputException(message);
        }
    }

    public static void validateTinyString(String fieldValue, String fieldName) {
        isMaxLengthAcceded(fieldValue, fieldName, TINY_STRING_MAX_LENGTH);
    }

    public static void validateShortString(String fieldValue, String fieldName) {
        isMaxLengthAcceded(fieldValue, fieldName, SHORT_STRING_MAX_LENGTH);
    }

    public static void validateMidString(String fieldValue, String fieldName) {
        isMaxLengthAcceded(fieldValue, fieldName, MID_STRING_MAX_LENGTH);
    }

    public static void validateLongString(String fieldValue, String fieldName) {
        isMaxLengthAcceded(fieldValue, fieldName, LONG_STRING_MAX_LENGTH);
    }

    public static void isMaxLengthAcceded(String fieldValue, String fieldName, int maxLength) {
        if (fieldValue.length() > maxLength) {
            String message = String.format("Field: %s should be maximum %d characters long.", fieldName, maxLength);
            throw new InvalidInputException(message);
        }
    }

}
