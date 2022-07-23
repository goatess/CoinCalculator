package monedas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChangeTest {

    @Test
    public void get_money_change_in_2_euro_coins(){
        Change change = new Change(8);
        int twoEuroCoins = 0;
        twoEuroCoins = change.getCoins().get(0);
        assertEquals(4, twoEuroCoins);

    }

        @Test
    public void get_money_change_in_2_and_1_euro_coins(){
        Change change = new Change(3);
        int twoEuroCoins = 0;
        twoEuroCoins = change.getCoins().get(0) + change.getCoins().get(1);
        assertEquals(2, twoEuroCoins);

    }
}
