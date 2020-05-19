package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketInformationByTime implements Comparator<TicketInformation> {
        private int id;
        private int price;
        private String from;
        private String to;
        private double time;


    @Override
    public int compare(TicketInformation o1, TicketInformation o2) {
        return (int) (o1.getTime() - o2.getTime());
    }
}
