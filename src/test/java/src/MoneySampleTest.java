package src;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.model.ItemBigDecimal;
import src.model.ItemDouble;
import src.model.ItemJodaMoney;
import src.model.ItemLowestDenomination;

public class MoneySampleTest {

    private List<ItemDouble> productsDouble = new ArrayList<>();
    private List<ItemBigDecimal> productsBigDecimal = new ArrayList<>();
    private List<ItemLowestDenomination> productsLowestDenomination = new ArrayList<>();
    private List<ItemJodaMoney> productsJodaMoney = new ArrayList<>();

    private final double RECHARGED_WITH = 1.0;
    private final double CANDY_CHOCOLATE = 0.10;
    private final double CANDY_ORANGE = 0.20;
    private final double CANDY_MINT = 0.30;
    private final double CANDY_MANGO = 0.40;


    @Before
    public void setupBefore() {
        productsDouble = new ArrayList<>();
        productsDouble.add(new ItemDouble("Candy_Chocolate", CANDY_CHOCOLATE));
        productsDouble.add(new ItemDouble("Candy_Orange", CANDY_ORANGE));
        productsDouble.add(new ItemDouble("Candy_Mint", CANDY_MINT));


        productsBigDecimal.add(new ItemBigDecimal("Candy_Chocolate", new BigDecimal(String.valueOf(CANDY_CHOCOLATE))));
        productsBigDecimal.add(new ItemBigDecimal("Candy_Orange", new BigDecimal(String.valueOf(CANDY_ORANGE))));
        productsBigDecimal.add(new ItemBigDecimal("Candy_Mint", new BigDecimal(String.valueOf(CANDY_MINT))));


        productsLowestDenomination.add(new ItemLowestDenomination("Candy_Chocolate", (long) (CANDY_CHOCOLATE * 100)));
        productsLowestDenomination.add(new ItemLowestDenomination("Candy_Orange", (long) (CANDY_ORANGE * 100)));
        productsLowestDenomination.add(new ItemLowestDenomination("Candy_Mint", (long) (CANDY_MINT * 100)));


        productsJodaMoney.add(new ItemJodaMoney("Candy_Chocolate", Money.of(CurrencyUnit.USD, CANDY_CHOCOLATE)));
        productsJodaMoney.add(new ItemJodaMoney("Candy_Orange", Money.of(CurrencyUnit.USD, CANDY_ORANGE)));
        productsJodaMoney.add(new ItemJodaMoney("Candy_Mint", Money.of(CurrencyUnit.USD, CANDY_MINT)));

    }


    @Test
    public void testIfWeCanAddCandyWhenUsingDouble() {
        double balanceAmount = RECHARGED_WITH;
        for (ItemDouble itemDouble : productsDouble) {
            balanceAmount -= itemDouble.getPrice();
        }
        System.out.println("Balance amount in double before buying candy :" + balanceAmount);
        Assert.assertTrue(balanceAmount - CANDY_MANGO >= 0);
    }

    @Test
    public void testIfWeCanAddCandyWhenUsingBigDecimal() {
        BigDecimal balanceAmount = new BigDecimal(Double.toString(RECHARGED_WITH));
        for (ItemBigDecimal itemBigDecimal : productsBigDecimal) {
            balanceAmount = balanceAmount.subtract(itemBigDecimal.getPrice());

        }
        System.out.println("Balance amount in double before buying candy :" + balanceAmount);
        Assert.assertTrue(balanceAmount.subtract(new BigDecimal(Double.toString(CANDY_MANGO))).doubleValue() >= 0);
    }


    @Test
    public void testIfWeCanAddCandyWhenUsingLowestDenomination() {
        long balanceAmount = (long) (RECHARGED_WITH * 100);
        for (ItemLowestDenomination itemLowestDenomination : productsLowestDenomination) {
            balanceAmount = balanceAmount - itemLowestDenomination.getPrice();

        }
        System.out.println("Balance amount in lowest denomination before buying candy :" + balanceAmount);
        Assert.assertTrue(balanceAmount - (CANDY_MANGO * 100) >= 0);
    }


    @Test
    public void testIfWeCanAddCandyWhenUsingJodaMoney() {
        Money balanceAmount = Money.of(CurrencyUnit.USD, RECHARGED_WITH);
        for (ItemJodaMoney itemJodaMoney : productsJodaMoney) {
            balanceAmount = balanceAmount.minus(itemJodaMoney.getPrice());

        }
        System.out.println("Balance amount in Joda Money before buying candy :" + balanceAmount);
        Assert.assertTrue(balanceAmount.minus(Money.of(CurrencyUnit.USD, CANDY_MANGO)).isPositiveOrZero());
    }
}

