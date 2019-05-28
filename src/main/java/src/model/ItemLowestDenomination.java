package src.model;

public class ItemLowestDenomination {
    private String name;
    private long price;

    public ItemLowestDenomination(String item, long price) {
        this.name = item;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
