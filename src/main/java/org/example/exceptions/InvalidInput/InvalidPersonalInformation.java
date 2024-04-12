package org.example.exceptions.InvalidInput;

public class InvalidPersonalInformation  extends InvalidInput{
    public InvalidPersonalInformation (String message) {
        super(message);
    }

    public InvalidPersonalInformation () {
        super("Wrong Personal Information Exception");
    }
}
