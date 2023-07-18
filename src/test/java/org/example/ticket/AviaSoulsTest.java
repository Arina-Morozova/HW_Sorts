package org.example.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Шереметьево", "Пулково", 2500, 14, 15);
    Ticket ticket2 = new Ticket("Стамбул", "Дубай", 17_000, 9, 14);
    Ticket ticket3 = new Ticket("Нью-Йорк", "Чикаго", 3000, 14, 15);
    Ticket ticket4 = new Ticket("Пекин", "Токио", 2500, 5, 6);
    Ticket ticket5 = new Ticket("Шереметьево", "Пулково", 2000, 18, 19);

    @Test
    public void shouldComparePriceIfLess() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfMore() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfEqual() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPriceIfTwoTickets() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket5, ticket1};
        Ticket[] actual = manager.search("Шереметьево", "Пулково");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPriceIfOneTicket() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("Стамбул", "Дубай");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPriceIfZeroTicket() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Шанхай", "Владивосток");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeIfMore() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        int expected = 1;
        int actual = timeComparator.compare(ticket2, ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeIfLess() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeIfEqual() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        int expected = 0;
        int actual = timeComparator.compare(ticket1, ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTimeIfTwoTickets() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Шереметьево", "Пулково", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTimeIfOneTicket() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchAndSortBy("Стамбул", "Дубай", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTimeIfZeroTicket() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Дубай", "Стамбул", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
