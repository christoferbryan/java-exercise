package com.adepuu.exercises.session7;

import java.util.UUID;

public class User {
    private final String ID;
    private Ticket ticket;
    public User(){
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
    }

    public String getID(){
        return ID;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public void saveTicket(Ticket ticket){
        this.ticket = ticket;
    }
}
