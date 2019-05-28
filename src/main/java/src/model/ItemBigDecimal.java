package src.model;

import java.math.BigDecimal;

public class ItemBigDecimal {
    private String name;
    private BigDecimal price;

    public ItemBigDecimal(String item, BigDecimal price) {
        this.name = item;
        this.price = price;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
