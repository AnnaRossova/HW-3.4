package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    MovieItem first = new MovieItem(1, "Bladshort", "action");
    MovieItem second = new MovieItem(2, "Forward", "cartoon");
    MovieItem third = new MovieItem(3, "Hotel Belgrad", "comedy");
    MovieItem fourth = new MovieItem(4, "Gentlemens", "action");
    MovieItem fifth = new MovieItem(5, "Invisible Man", "triller");


    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }


    @Test
    void shouldFindAll() {
        assertArrayEquals(new MovieItem[]{first, second, third, fourth, fifth}, repository.findAll());
    }


    @Test
    void shouldFindById() {
        assertEquals(third, repository.findById(3));
        assertEquals(fourth, repository.findById(4));
        assertEquals(null, repository.findById(6));
    }


    @Test
    void shouldSave() {
        MovieItem sixth = new MovieItem(6, "Troll's tour", "cartoon");
        repository.save(sixth);
        assertArrayEquals(new MovieItem[]{first, second, third, fourth, fifth, sixth}, repository.findAll());
    }


    @Test
    void shouldRemoveById() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        assertArrayEquals(new MovieItem[]{second, third, fourth, fifth}, repository.findAll());
    }


    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        assertArrayEquals(new MovieItem[]{}, repository.findAll());
    }

}

