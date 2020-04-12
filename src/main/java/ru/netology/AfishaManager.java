package ru.netology;

public class AfishaManager {
    private MovieItem[] items = new MovieItem[0];
    private int itemsToReturn;


    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }


    public AfishaManager(int itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }


    public MovieItem[] getLast() {
        int length = itemsToReturn;
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
