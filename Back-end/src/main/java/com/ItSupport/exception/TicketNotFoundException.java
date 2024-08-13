package com.ItSupport.exception;

public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException() {
        super("Ticket not found !");
    }
}
