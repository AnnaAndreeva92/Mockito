package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.CartRepository;

public class CartManager {
    private CartRepository repository;

    public CartManager(CartRepository repository) {

        this.repository = repository;
    }

    public void add(Movie film) {

        repository.save(film);
    }

    public Movie[] getAll() {
        Movie[] films = repository.findAll();
        Movie[] result = new Movie[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Movie[] showAll() {
        return repository.findAll();
    }


}
