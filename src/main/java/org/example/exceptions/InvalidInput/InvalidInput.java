package org.example.exceptions.InvalidInput;

public class InvalidInput extends Exception {

    public InvalidInput(String message) {
        super("invalid Input _ "+message);
    }
}
