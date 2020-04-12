package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager(10);

@Test
void shouldAdd() {
    MovieItem first = new MovieItem (1, "Bladshort", "action");
    MovieItem second = new MovieItem (4,"Gentlemens", "action");
    MovieItem third = new MovieItem (5, "Invisible Man", "triller");
    MovieItem fourth = new MovieItem (7, "Numder 1", "comedy");

    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(fourth);

    MovieItem[] actual = manager.getLast();
    MovieItem[] expected = new MovieItem[]{fourth, third, second, first};

    assertArrayEquals(expected, actual);
}

@ Test
void shouldEmpty() {

    MovieItem [] actual = manager.getLast();
    MovieItem [] expected = new MovieItem []{};

    assertArrayEquals(expected, actual);
}

@Test
void shouldAddMoreThanTen() {
    MovieItem first = new MovieItem (1, "Bladshort", "action");
    MovieItem second = new MovieItem(2, "Forward",  "cartoon");
    MovieItem third = new MovieItem (5, "Invisible Man", "triller");
    MovieItem fourth = new MovieItem (3, "Hotel Belgrad",  "comedy");
    MovieItem fifth = new MovieItem (4, "Gentlemens",  "action");
    MovieItem sixth = new MovieItem (6,"Troll's tour", "cartoon");
    MovieItem seventh = new MovieItem(9, "The green mile",  "comedy");
    MovieItem eighth = new MovieItem(7, "Numder 1",  "comedy");
    MovieItem ninth = new MovieItem(10, "Inception",  "action");
    MovieItem tenth = new MovieItem(8, "Leon", "action");
    MovieItem eleventh = new MovieItem(11, "Fight club",  "action");

    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(fourth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eighth);
    manager.add(ninth);
    manager.add(tenth);
    manager.add(eleventh);

    MovieItem[] actual = manager.getLast();
    MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

    assertArrayEquals(expected, actual);
}

}
