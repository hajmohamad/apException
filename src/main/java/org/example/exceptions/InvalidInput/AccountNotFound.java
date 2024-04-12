package org.example.exceptions.InvalidInput;

public class AccountNotFound extends InvalidInput {
    public AccountNotFound(String s) {
        super(s);
    }

    public AccountNotFound() {
        super("AccountNotFound");
    }
}
