package monedas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChangeTest {

    @Test
    public void get_money_change_in_2_euro_coins() {
        final String TWO_EURO_COINS = "4 coins. (4) 2 euro coins, (0) 1 euro coins, (0) 50 cents coins, (0) 20 cents coins, (0) 10 cent coins, ";
        Change change = new Change(8);
        String twoEuroCoins = change.toString();
        assertEquals(TWO_EURO_COINS, twoEuroCoins);
    }

    @Test
    public void get_money_change_with_2_and_1_euro_coins() {
        final String COINS = "2 coins. (1) 2 euro coins, (1) 1 euro coins, (0) 50 cents coins, (0) 20 cents coins, (0) 10 cent coins, ";
        Change change = new Change(3);
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_50_cent_coins() {
        final String COINS = "3 coins. (1) 2 euro coins, (1) 1 euro coins, (1) 50 cents coins, (0) 20 cents coins, (0) 10 cent coins, ";
        Change change = new Change("3,50");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_20_cent_coins() {
        final String COINS = "4 coins. (1) 2 euro coins, (1) 1 euro coins, (1) 50 cents coins, (1) 20 cents coins, (0) 10 cent coins, ";
        Change change = new Change("3,70");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_10_cent_coins() {
        final String COINS = "4 coins. (1) 2 euro coins, (1) 1 euro coins, (1) 50 cents coins, (0) 20 cents coins, (1) 10 cent coins, ";
        Change change = new Change("3,60");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }
}
