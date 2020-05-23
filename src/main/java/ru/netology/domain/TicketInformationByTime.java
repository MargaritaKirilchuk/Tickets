package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

public class TicketInformationByTime implements Comparator<TicketInformation> {


    @Override
    public int compare(TicketInformation o1, TicketInformation o2) {
        // для time используется тип double
        return (int) (o1.getTime() - o2.getTime());

    }
}
