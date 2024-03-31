package org.example.exceptions.Invalidrequests;

public class InvalidRequest extends Exception {
    public InvalidRequest(String message) {
        super("Invalid request :"+message);
    }
}
