package org.example.exceptions.InvalidInput;

public class AmountIsNegative  extends InvalidInput {
    public AmountIsNegative(String s) {
        super(s);
    }

    public AmountIsNegative() {
        super("Amount Is Negative");
    }
}
