package main.java.ru.miloslavskii.task;

public abstract class AllKindsOfSweets {

    private String name;
    private int weight;
    private double price;
    private int id;

    public AllKindsOfSweets(String name, int weight, double price, int id) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "AllKindsOfSweets{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
