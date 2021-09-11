package main.java.ru.miloslavskii.task;

import java.util.List;

public interface BoxOfSweets {

    List<AllKindsOfSweets> addSweet(AllKindsOfSweets sweet);

    void removeSweet(int index);

    int totalWeightBox(List<AllKindsOfSweets> allKindsOfSweets);

    double totalPriceBox(List<AllKindsOfSweets> allKindsOfSweets);

    void printAllTheSweets();
}
