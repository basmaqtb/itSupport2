package com.ItSupport.exception;

public class RegistrationException extends RuntimeException {

    /**
     * Constructs a new RegistrationException with a default detail message.
     * The default message is "User with this username already exists."
     */
    public RegistrationException() {
        super("User with this username already exists.");
    }
}