package com.ItSupport.exception;

public class PanneNotFoundException extends RuntimeException {

    public PanneNotFoundException() {
        super("Panne not found");
    }

}
