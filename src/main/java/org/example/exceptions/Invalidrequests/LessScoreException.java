package org.example.exceptions.Invalidrequests;

public class LessScoreException extends InvalidRequest {
    public LessScoreException(String message) {
        super(message);
    }

    public LessScoreException() {
        super("Your account score is insufficient");
    }
}
