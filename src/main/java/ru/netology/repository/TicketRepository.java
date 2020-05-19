package ru.netology.repository;

import ru.netology.domain.TicketInformation;

public class TicketRepository {
    private TicketInformation[] tickets = new TicketInformation[0];

    public void save(TicketInformation ticket){
        int length = tickets.length + 1;
        TicketInformation[] tmp = new TicketInformation[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public TicketInformation[] findAll(){
        return tickets;
    }

    public TicketInformation findById(int id) {
        for (TicketInformation ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id){
        int length = tickets.length - 1;
        TicketInformation[] tmp = new TicketInformation[length];
        int index = 0;
        for(TicketInformation ticket : tickets){
            if (ticket.getId() != id){
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}

