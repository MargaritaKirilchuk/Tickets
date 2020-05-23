package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;
import ru.netology.domain.TicketInformationByTime;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTestTime {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Comparator comparator = new TicketInformationByTime();

    private TicketInformation firstTicket = new TicketInformation(1,7_241,"LED","BCN",22.35);
    private TicketInformation secondTicket = new TicketInformation(2,22_943,"LED","BCN",7.32);
    private TicketInformation thirdTicket = new TicketInformation(3,13_887,"LED","BCN",8.40);
    private TicketInformation fourthTicket = new TicketInformation(4,2_948,"LED","AER",3.05);
    private TicketInformation fifthTicket = new TicketInformation(5,3_875,"LED","AER",7.35);
    private TicketInformation sixthTicket = new TicketInformation(6,3_888,"LED","AER",6.01);

    @Test
    public void shouldFindTicketIfExist() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);
        manager.add(fourthTicket);
        manager.add(fifthTicket);
        manager.add(sixthTicket);

        TicketInformation[] actual = manager.findAllSortByTime("LED","BCN", comparator);
        TicketInformation[] expected = new TicketInformation[] {secondTicket, thirdTicket, firstTicket};

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldFindTicketIfEmpty() {
        TicketInformation[] actual = manager.findAllSortByTime("LED","BCN", comparator);
        TicketInformation[] expected = new TicketInformation[] {};

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldFindTicketIfNotExist() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);

        TicketInformation[] actual = manager.findAllSortByTime("BCN","LED", comparator);
        TicketInformation[] expected = new TicketInformation[] {};

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldFindTicketIfWrongWay() {
        manager.add(fourthTicket);
        manager.add(fifthTicket);
        manager.add(sixthTicket);

        TicketInformation[] actual = manager.findAllSortByTime("LED","BCN", comparator);
        TicketInformation[] expected = new TicketInformation[] {};

        assertArrayEquals (expected, actual);

    }



}