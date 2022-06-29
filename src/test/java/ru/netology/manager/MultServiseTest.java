package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;
@ExtendWith(MockitoExtension.class)
public class MultServiseTest {

    PurchaseItem first = new PurchaseItem(1, "Bladshot", "http://", "actionMovie");
    PurchaseItem second = new PurchaseItem(2, "Forward", "http://", "cartoon");
    PurchaseItem third = new PurchaseItem(3, "HotelBelgrad", "http://", "comedy");
    PurchaseItem fourth = new PurchaseItem(4, "Gentlemen", "http://", "actionMovie");
    PurchaseItem fifth = new PurchaseItem(5, "InvisibleMan", "http://", "horrors");
    PurchaseItem sixth = new PurchaseItem(6, "Trolls.WorldTour", "http://", "cartoon");
    PurchaseItem seventh = new PurchaseItem(7, "NumberOne", "http://", "comedy");
    PurchaseItem eighth = new PurchaseItem(8, "DreamMakers", "http://", "animation");
    PurchaseItem ninth = new PurchaseItem(9, "Missing", "http://", "thriller");
    PurchaseItem tenth = new PurchaseItem(10, "RocketScientist", "http://", "drama");

    @Test
    public void removal(){
        CartRepository repo = new CartRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);
        repo.save(seventh);
        repo.save(eighth);
        repo.save(ninth);
        repo.save(tenth);

        repo.removeById(4);

        PurchaseItem[] actual = repo.findAll();
        PurchaseItem[] expected = { first,second,third,fifth,sixth,seventh,eighth,ninth,tenth};

        Assertions.assertArrayEquals(expected,actual);
    }
}
