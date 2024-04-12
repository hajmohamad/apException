package org.example.exceptions.Invalidrequests;

public class WithdrawalLimit  extends InvalidRequest {
    public WithdrawalLimit () {
        super("The Withdrawal Limit is $10000");
    }

    public WithdrawalLimit (String message) {
        super(message);
    }
}
