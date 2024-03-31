package org.example.exceptions.Invalidrequests;

public class moreThanDrawLimitException extends InvalidRequest {
    public moreThanDrawLimitException() {
        super("The amount entered is more than the withdrawal limit");
    }

    public moreThanDrawLimitException(String message) {
        super(message);
    }
}
