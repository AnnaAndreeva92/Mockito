package ru.netology.repository;

import ru.netology.domain.Movie;

public class CartRepository {
    private Movie[] films = new Movie[0];


    public void save(Movie film) {
        int length = films.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Movie[] findAll() {

        return films;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public Movie findById(int id) {
        for (Movie item : films) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeAll() {
        films = new Movie[0];
    }

}
