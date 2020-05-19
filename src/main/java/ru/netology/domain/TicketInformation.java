package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketInformation implements Comparable <TicketInformation>{
    private int id;
    private int price;
    private String from;
    private String to;
    private double time;

    @Override
    public int compareTo(TicketInformation o) {
        return price - o.price;
    }
}
