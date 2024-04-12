package org.example.exceptions.Invalidrequests;

public class NotEnoughCredit extends InvalidRequest {
    public NotEnoughCredit() {
        super("Your Credit is not Enough");
    }

    public NotEnoughCredit(String message) {
        super(message);
    }
}
