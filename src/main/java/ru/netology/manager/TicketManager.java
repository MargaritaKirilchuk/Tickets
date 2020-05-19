package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    public TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInformation ticket){
        repository.save(ticket);
    }

    public TicketInformation[] findAll(String from, String to){
        TicketInformation[] result = new TicketInformation[0];
        for (TicketInformation ticket : repository.findAll()){
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)){
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                System.arraycopy(result,0,tmp,0,result.length);
                tmp[tmp.length-1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public void removeById (int id){
        repository.removeById(id);
    }

    public TicketInformation findById(int id) {
        return repository.findById(id);
    }
}
