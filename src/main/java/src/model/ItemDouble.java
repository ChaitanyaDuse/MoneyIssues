package src.model;

public class ItemDouble {
    private String name;
    private double price;

    public ItemDouble(String item, double price) {
        this.name = item;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
