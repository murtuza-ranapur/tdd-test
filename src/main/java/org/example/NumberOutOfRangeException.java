package org.example;

public class NumberOutOfRangeException extends RuntimeException {
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}
