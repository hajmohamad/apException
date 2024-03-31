package org.example.exceptions.Invalidrequests;

public class lessAccountBalanceException extends InvalidRequest {
    public lessAccountBalanceException() {
        super("The account balance is less than the requested amount");
    }

    public lessAccountBalanceException(String message) {
        super(message);
    }
}
