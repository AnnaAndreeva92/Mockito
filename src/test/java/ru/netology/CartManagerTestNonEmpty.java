package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;
import ru.netology.repository.CartRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CartManagerTestNonEmpty {
    @Mock
    private CartRepository repository;
    @InjectMocks
    private CartManager manager;

    private PurchaseItem first = new PurchaseItem(1, "Bladshot", "http://", "actionMovie");
    private PurchaseItem second = new PurchaseItem(2, "Forward", "http://", "cartoon");
    private PurchaseItem third = new PurchaseItem(3, "HotelBelgrad", "http://", "comedy");
    private PurchaseItem fourth = new PurchaseItem(4, "Gentlemen", "http://", "actionMovie");
    private PurchaseItem fifth = new PurchaseItem(5, "InvisibleMan", "http://", "horrors");
    private PurchaseItem sixth = new PurchaseItem(6, "Trolls.WorldTour", "http://", "cartoon");
    private PurchaseItem seventh = new PurchaseItem(7, "NumberOne", "http://", "comedy");
    private PurchaseItem eighth = new PurchaseItem(8, "DreamMakers", "http://", "animation");
    private PurchaseItem ninth = new PurchaseItem(9, "Missing", "http://", "thriller");
    private PurchaseItem tenth = new PurchaseItem(10, "RocketScientist", "http://", "drama");
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
    public void test() {
        PurchaseItem[] returned = new PurchaseItem[]{first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth};
        doReturn(returned).when(repository).findAll();
        manager.removeById(4);
        PurchaseItem[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, third, second, first};
        PurchaseItem[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}

