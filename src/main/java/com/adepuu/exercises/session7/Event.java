package com.adepuu.exercises.session7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Event {
    private final String ID;
    private final HashMap<String, Ticket> availableTickets = new HashMap<>();
    private final ArrayList<String> bookingList = new ArrayList<>();

    private int ticketQuota = 0;
    private int ticketSold = 0;

    public Event(int maxTickets){
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ticketQuota = maxTickets;
    }

    public boolean bookTicket(String userID){
        if(ticketSold >= ticketQuota){
            System.out.println("Tickets are sold out.");
            return false;
        }

        if(bookingList.contains(userID)){
            System.out.println("Only allowed to book 1 ticket");
            return false;
        }

        return true;
    }

    public Ticket confirmTicket(String userID){
        bookingList.add(userID);
        if(bookingList.contains(userID) && ticketSold<=ticketQuota){
            ticketSold++;
            Ticket ticket = new Ticket(this.ID);
            availableTickets.put(ticket.getID(), ticket);

            return ticket;
        }
        return null;
    }
}
