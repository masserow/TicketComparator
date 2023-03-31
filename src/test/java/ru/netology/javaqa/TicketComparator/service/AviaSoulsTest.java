package ru.netology.javaqa.TicketComparator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket t1 = new Ticket("London", "Paris", 5_000, 16, 22);//6
    Ticket t2 = new Ticket("Helsinki", "Berlin", 10_000, 12, 20);
    Ticket t3 = new Ticket("London", "Paris", 7_000, 5, 8);//3
    Ticket t4 = new Ticket("Helsinki", "Berlin", 4_000, 10, 14);
    Ticket t5 = new Ticket("Helsinki", "Berlin", 12_000, 2, 7 );
    Ticket t6 = new Ticket("London", "Paris", 1_000, 11, 21);//10
    Ticket t7 = new Ticket("Helsinki", "Berlin", 15_000, 9, 19);
    Ticket t8 = new Ticket("London", "Paris", 6_000, 6, 7);//1
    Ticket t9 = new Ticket("Helsinki", "Berlin", 9_000, 1, 14);
    Ticket t10 = new Ticket("London", "Paris", 11_000, 7, 9);//2
    Ticket t11 = new Ticket("London", "Berlin", 3_000, 12, 15);


    @Test
    public void testCompareTo()  {
        AviaSouls repo = new AviaSouls();
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);
        repo.add(t7);
        repo.add(t8);
        repo.add(t9);
        repo.add(t10);
        repo.add(t11);

        Ticket[] expected = {t4, t9, t2, t5, t7};
        Ticket[] actual = repo.search("Helsinki", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparator()  {
        AviaSouls repo = new AviaSouls();
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);
        repo.add(t7);
        repo.add(t8);
        repo.add(t9);
        repo.add(t10);
        repo.add(t11);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t8, t10, t3, t1, t6};
        Ticket[] actual = repo.searchAndSortBy("London", "Paris", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void testSearchTicket()  {
        AviaSouls repo = new AviaSouls();
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);
        repo.add(t7);
        repo.add(t8);
        repo.add(t9);
        repo.add(t10);
        repo.add(t11);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t11};
        Ticket[] actual = repo.searchAndSortBy("London", "Berlin", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNotExistTicket()  {
        AviaSouls repo = new AviaSouls();
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);
        repo.add(t7);
        repo.add(t8);
        repo.add(t9);
        repo.add(t10);
        repo.add(t11);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = repo.searchAndSortBy("Berlin", "Paris", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
