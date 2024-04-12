package org.example.exceptions.Invalidrequests;

public class LoanLimit extends InvalidRequest {
    public LoanLimit(String message) {
        super(message);
    }
    public LoanLimit() {
        super("Loan limit for your account type is 500");
    }
}
