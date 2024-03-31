package org.example.exceptions.InvalidInput;

public class WrongPersonalInformationException extends IllegalArgumentException{
    public WrongPersonalInformationException(String message) {
        super(message);
    }

    public WrongPersonalInformationException() {
        super("Wrong Personal Information Exception");
    }
}
