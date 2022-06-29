package ru.netology;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;
import ru.netology.manager.CartManager;




public class Main {

    public static void main(String[] args) {
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

        PurchaseItem[] all = manager.getAll();


    }
}
