package ru.netology;

public class AfishaManager {
    private AfishaRepository repository;
    private int itemsToReturn;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
        this.itemsToReturn = 10;
    }

    public void add(MovieItem item) {
        repository.save(item);
    }

    public MovieItem[] getLast() {
        int length = itemsToReturn;
        MovieItem[] items = repository.findAll();
        if (length > items.length) {
            length = items.length;
        }
        MovieItem[] result = new MovieItem[length];
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
