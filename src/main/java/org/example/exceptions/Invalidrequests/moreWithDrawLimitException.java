package org.example.exceptions.Invalidrequests;

public class moreWithDrawLimitException extends InvalidRequest {
    public moreWithDrawLimitException() {
        super("The account balance is less than the requested amount");
    }

    public moreWithDrawLimitException(String message) {
        super(message);
    }
}
