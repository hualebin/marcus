package org.marcus.lib.all.exception;

public class TestException extends TestParentException {
    public TestException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        String message = getLocalizedMessage();
        return (message != null) ? (message) : getClass().getName();
    }
}
