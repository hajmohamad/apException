package org.example.exceptions.Invalidrequests;

public class moreThanDepositLimitException extends InvalidRequest{
    public moreThanDepositLimitException() {
        super("The amount entered is more than the deposit limit");
    }

    public moreThanDepositLimitException(String message) {
        super(message);
    }
}
