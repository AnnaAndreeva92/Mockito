package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    private MovieManager manager = new MovieManager();

    private Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    private Movie second = new Movie(2, "Forward", "http://", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    private Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    private Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    private Movie sixth = new Movie(6, "Trolls.WorldTour", "http://", "cartoon");
    private Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    private Movie eighth = new Movie(8, "DreamMakers", "http://", "animation");
    private Movie ninth = new Movie(9, "Missing", "http://", "thriller");
    private Movie tenth = new Movie(10, "RocketScientist", "http://", "drama");

    Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};


    @Test
    public void mustShowValid() {
        MovieManager manager = new MovieManager(5);

        Movie movieToAdd = new Movie(11, "NumberFive", "http://", "horrors");
        manager.add(String.valueOf(movieToAdd));
        String[] actual = manager.findLast();
        Movie[] expected = {new Movie(11, "NumberFive", "http://", "horrors"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);


    }
}


