package org.example.exceptions.InvalidInput;

public class IllegalArgumentException extends Exception {

    public IllegalArgumentException(String message) {
        super("invalid Input,"+message);
    }
}
