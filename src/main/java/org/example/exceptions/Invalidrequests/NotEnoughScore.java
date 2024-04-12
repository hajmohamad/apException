package org.example.exceptions.Invalidrequests;

public class NotEnoughScore extends InvalidRequest {
    public NotEnoughScore(String message) {
        super(message);
    }

    public NotEnoughScore() {
        super("Your account score is not Enough");
    }
}
