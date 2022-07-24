package monedas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChangeTest {

    @Test
    public void get_money_change_in_2_euro_coins() {
        final String TWO_EURO_COINS = "4 coins. (4) TWO_EURO coins, ";
        Change change = new Change("8");
        String twoEuroCoins = change.toString();
        assertEquals(TWO_EURO_COINS, twoEuroCoins);
    }

    @Test
    public void get_money_change_with_2_and_1_euro_coins() {
        final String COINS = "2 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, ";
        Change change = new Change("3");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_50_cent_coins() {
        final String COINS = "3 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, ";
        Change change = new Change("3,50");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_20_cent_coins() {
        final String COINS = "4 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, ";
        Change change = new Change("3,70");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_10_cent_coins() {
        final String COINS = "5 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, (1) TEN_CENT coins, ";
        Change change = new Change("3,80");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_5_cent_coins() {
        final String COINS = "6 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, (1) TEN_CENT coins, (1) FIVE_CENT coins, ";
        Change change = new Change("3,85");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_2_cent_coins() {
        final String COINS = "7 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, (1) TEN_CENT coins, (1) FIVE_CENT coins, (1) TWO_CENT coins, ";
        Change change = new Change("3,87");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_1_cent_coins() {
        final String COINS = "8 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, (1) TEN_CENT coins, (1) FIVE_CENT coins, (1) TWO_CENT coins, (1) ONE_CENT coins, ";
        Change change = new Change("3,88");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_3_decimals() {
        final String COINS = "5 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) TWENTY_CENT coins, (2) TWO_CENT coins, ";
        Change change = new Change("3,245");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_1_decimal() {
        final String COINS = "5 coins. (1) TWO_EURO coins, (1) ONE_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, (1) TEN_CENT coins, ";
        Change change = new Change("3,8");
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_integer_input() {
        final String COINS = "16 coins. (16) TWO_EURO coins, ";
        Change change = new Change(32);
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }

    @Test
    public void get_money_change_with_float_input() {
        final String COINS = "19 coins. (16) TWO_EURO coins, (1) FIFTY_CENT coins, (1) TWENTY_CENT coins, (1) FIVE_CENT coins, ";
        Change change = new Change(32.75f);
        String changeCoins = change.toString();
        assertEquals(COINS, changeCoins);
    }
}
