package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    public static void main(String[] args) {
        String[] movies = {
                "Bladshot",
                "Forward",
                "HotelBelgrad",
                "Gentlemen",
                "InvisibleMan",
                "Trolls.WorldTour",
                "NumberOne",
                "DreamMakers",
                "Missing",
                "RocketScientist"
        };
    }

    @Test
    public void addMovie() {
        MovieManager manager = new MovieManager(5);
        manager.add("Bladshot");
        manager.add("Forward");
        manager.add("HotelBelgrad");
        manager.add("Gentlemen");
        manager.add("InvisibleMan");
        manager.add("Trolls.WorldTour");
        manager.add("NumberOne");
        manager.add("DreamMakers");
        manager.add("Missing");
        manager.add("RocketScientist");

        String newMovie = new String("threeСats");
        manager.add(newMovie);
        String[] actual = manager.finsLast();
        String[] expected = {new String("threeСats"), "RocketScientist", "Missing", "DreamMakers", "NumberOne"};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void ListAllMoviesInTheOrderTheyWereAdded() {
        MovieManager manager = new MovieManager(10);
        manager.add("Bladshot");
        manager.add("Forward");
        manager.add("HotelBelgrad");
        manager.add("Gentlemen");
        manager.add("InvisibleMan");
        manager.add("Trolls.WorldTour");
        manager.add("NumberOne");
        manager.add("DreamMakers");
        manager.add("Missing");
        manager.add("RocketScientist");

        String[] actual = manager.findAll();
        String[] expected = {"Bladshot", "Forward", "HotelBelgrad", "Gentlemen", "InvisibleMan", "Trolls.WorldTour", "NumberOne", "DreamMakers", "Missing", "RocketScientist"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void DisplayingTheLatestAddedMoviesInReverseOrder() {
        MovieManager manager = new MovieManager(10);
        manager.add("Bladshot");
        manager.add("Forward");
        manager.add("HotelBelgrad");
        manager.add("Gentlemen");
        manager.add("InvisibleMan");
        manager.add("Trolls.WorldTour");
        manager.add("NumberOne");
        manager.add("DreamMakers");
        manager.add("Missing");
        manager.add("RocketScientist");
        String[] actual = manager.finsLast();
        String[] expected = {"RocketScientist", "Missing", "DreamMakers", "NumberOne", "Trolls.WorldTour", "InvisibleMan", "Gentlemen", "HotelBelgrad", "Forward", "Bladshot"};
        Assertions.assertArrayEquals(actual, expected);
    }
}


