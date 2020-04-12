package ru.netology;

public class AfishaRepository {
    private MovieItem[] items = new MovieItem[0];

    public MovieItem[] findAll() {
        return items;
    }

    MovieItem findById(int id) {
        for (MovieItem item : items) {
            if (item.getMovieId() == id) {
                return item;
            }
        }
        return null;
    }

    public void save(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public boolean removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        boolean founded = false;
        for (MovieItem item : items) {
            if (item.getMovieId() != id) {
                tmp[index] = item;
                index++;
            } else {
                founded = true;
            }
        }
        items = tmp;
        return founded;
    }

    public void removeAll() {
        items = new MovieItem[0];
    }
}
