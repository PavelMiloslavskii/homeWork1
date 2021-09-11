package main.java.ru.miloslavskii.task;

import java.util.ArrayList;
import java.util.List;

public class BoxOfSweetsImpl implements BoxOfSweets {

    private List<AllKindsOfSweets> allKindsOfSweets = new ArrayList<>();
    {
        allKindsOfSweets.add(new Marmalade("Haribo", 16, 24.90, 9990));
        allKindsOfSweets.add(new Chocolate("Milka", 20, 35.90, 9991));
        allKindsOfSweets.add(new Cookie("ChocoPie", 35, 55.80, 9992));
    }

    @Override
    public List<AllKindsOfSweets> addSweet(AllKindsOfSweets sweet) {
        allKindsOfSweets.add(sweet);
        return allKindsOfSweets;
    }

    @Override
    public void removeSweet(int index) {
        allKindsOfSweets.remove(index);
    }

    @Override
    public int totalWeightBox(List<AllKindsOfSweets> allKindsOfSweets) {
        int countWeight = 0;
        for (AllKindsOfSweets kindsOfSweet : allKindsOfSweets) {
            countWeight += kindsOfSweet.getWeight();
        }
        return countWeight;
    }

    @Override
    public double totalPriceBox(List<AllKindsOfSweets> allKindsOfSweets) {
        double countPrice = 0;
        for (AllKindsOfSweets kindsOfSweets : allKindsOfSweets) {
            countPrice += kindsOfSweets.getPrice();
        }
        return countPrice;
    }

    @Override
    public void printAllTheSweets() {
        System.out.println("Содержимое коробки: ");
        for (AllKindsOfSweets kindsOfSweets : allKindsOfSweets) {
            System.out.println(kindsOfSweets);
        }
    }

    // Метод smartPriceBox() пишется аналогично
    public void smartWeightBox(List<AllKindsOfSweets> allKindsOfSweets, int targetWeight) {
        int min = allKindsOfSweets.get(0).getWeight();
        int index = 0;
        while (totalWeightBox(allKindsOfSweets) > targetWeight) {
            for (int i = 0; i < allKindsOfSweets.size(); i++) {
                int resultWeight = allKindsOfSweets.get(i).getWeight();
                if (resultWeight < min) {
                    min = resultWeight;
                    index = i;
                }
            }
            allKindsOfSweets.remove(index);
        }
    }


    public static void main(String[] args) {
        BoxOfSweetsImpl boxOfSweets = new BoxOfSweetsImpl();
        // Добавить сладость в коробку
        boxOfSweets.allKindsOfSweets.add(new Marmalade("Frutella", 15, 34.90, 9993));

        // Вывести информацию содержтимого коробки
        boxOfSweets.printAllTheSweets();
        System.out.println();

        // Удалить сладость из коробки
        boxOfSweets.allKindsOfSweets.remove(3);
        boxOfSweets.printAllTheSweets();
        System.out.println();

        // Вывести общий вес коробки
        System.out.println("Общий вес коробки: " + boxOfSweets.totalWeightBox(boxOfSweets.allKindsOfSweets) + "g");
        System.out.println();

        // Вывести общую стоимость подарка
        System.out.println("Общая стоимость подарка: " + boxOfSweets.totalPriceBox(boxOfSweets.allKindsOfSweets) + "$");

        // Умная оптимизация веса
        boxOfSweets.smartWeightBox(boxOfSweets.allKindsOfSweets, 35);
        boxOfSweets.printAllTheSweets();
        System.out.println("Общий вес коробки: " + boxOfSweets.totalWeightBox(boxOfSweets.allKindsOfSweets) + "g");
    }
}
