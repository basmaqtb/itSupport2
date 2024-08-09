package com.ItSupport.exception;

public class TechnicianNotFoundException extends RuntimeException {

    public TechnicianNotFoundException() {
        super("Technician not found !");
    }
}