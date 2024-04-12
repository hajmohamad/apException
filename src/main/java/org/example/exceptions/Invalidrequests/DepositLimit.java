package org.example.exceptions.Invalidrequests;

public class DepositLimit extends InvalidRequest{
    public DepositLimit() {
        super("The Deposit Limit is $1000");
    }

    public DepositLimit(String message) {
        super(message);
    }
}
