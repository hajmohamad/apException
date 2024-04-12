package org.example.exceptions.Invalidrequests;

public class YouAreVeryPoor extends InvalidRequest{
   public YouAreVeryPoor(String message) {
        super(message);
    }
    public YouAreVeryPoor() {
        super("You are very poor");
    }

}
