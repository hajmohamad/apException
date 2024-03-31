package org.example.exceptions.InvalidInput;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String s) {
        super(s);
    }

    public AccountNotFoundException() {
        super("AccountNotFound");
    }
}
