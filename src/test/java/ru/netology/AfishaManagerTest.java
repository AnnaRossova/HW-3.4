package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    MovieItem first = new MovieItem(1, "Bladshort", "action");
    MovieItem second = new MovieItem(2, "Forward", "cartoon");
    MovieItem third = new MovieItem(5, "Invisible Man", "triller");
    MovieItem fourth = new MovieItem(3, "Hotel Belgrad", "comedy");
    MovieItem fifth = new MovieItem(4, "Gentlemens", "action");
    MovieItem sixth = new MovieItem(6, "Troll's tour", "cartoon");
    MovieItem seventh = new MovieItem(9, "The green mile", "comedy");
    MovieItem eighth = new MovieItem(7, "Numder 1", "comedy");
    MovieItem ninth = new MovieItem(10, "Inception", "action");
    MovieItem tenth = new MovieItem(8, "Leon", "action");
    MovieItem eleventh = new MovieItem(11, "Fight club", "action");


    @Test
    void shouldAdd() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        MovieItem[] returned = new MovieItem[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(fifth);

        manager.add(fifth);
        MovieItem[] actual = manager.getLast();
        MovieItem[] expected = new MovieItem[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository).save(fifth);
    }

    @Test
    void shouldEmpty() {

        MovieItem[] returned = new MovieItem[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(first);

        manager.add(first);
        MovieItem[] actual = manager.getLast();
        MovieItem[] expected = new MovieItem[]{};

        assertArrayEquals(expected, actual);
        verify(repository).save(first);

    }

    @Test
    void shouldAddMoreThanTen() {

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

        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(eleventh);

        manager.add(eleventh);
        MovieItem[] actual = manager.getLast();
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository).save(eleventh);
    }

}
