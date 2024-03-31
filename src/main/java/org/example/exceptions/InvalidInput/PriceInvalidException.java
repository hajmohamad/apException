package org.example.exceptions.InvalidInput;

public class PriceInvalidException extends Exception {
    public PriceInvalidException(String s) {
        super(s);
    }

    public PriceInvalidException() {
        super("The amount entered is invalid");
    }
}
