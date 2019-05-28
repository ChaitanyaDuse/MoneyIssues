package src.model;

import org.joda.money.Money;

public class ItemJodaMoney {
    private String name;
    private Money price;

    public ItemJodaMoney(String item, Money price) {
        this.name = item;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
