package ru.netology;

import ru.netology.domain.Movie;
import ru.netology.repository.CartRepository;
import ru.netology.manager.CartManager;


public class Main {

    public static void main(String[] args) {
        Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
        Movie second = new Movie(2, "Forward", "http://", "cartoon");
        Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
        Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
        Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
        Movie sixth = new Movie(6, "Trolls.WorldTour", "http://", "cartoon");
        Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
        Movie eighth = new Movie(8, "DreamMakers", "http://", "animation");
        Movie ninth = new Movie(9, "Missing", "http://", "thriller");
        Movie tenth = new Movie(10, "RocketScientist", "http://", "drama");


        CartRepository repo = new CartRepository();
        CartManager manager = new CartManager(repo);

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

        Movie[] all = manager.getAll();


    }
}
