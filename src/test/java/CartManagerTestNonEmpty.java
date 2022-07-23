import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.manager.CartManager;
import ru.netology.repository.CartRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CartManagerTestNonEmpty {
    @Mock
    private CartRepository repository = Mockito.mock(CartRepository.class);
    @InjectMocks
    private CartManager manager = new CartManager(repository);
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

    @BeforeEach
    public void start() {
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
    }

    @Test
    public void addMovie() {

        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(tenth);
        manager.add(tenth);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void showAll() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }
}
