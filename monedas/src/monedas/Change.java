package monedas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    private int moneyIn;
    private int centsIn;
    private int sum = 0;
    private List<Integer> coins = new ArrayList<>();

    public Change(int moneyIn) {
        this.moneyIn = moneyIn;
        prepareCoins();
        moneyIntoCoins();
        countCoins();
    }

    public Change(String money) {
        splitMoney(money);
        prepareCoins();
        moneyIntoCoins();
        countCoins();
    }

    private void splitMoney(String money) {
        String[] splittedMoney = new String[2];
        splittedMoney = money.split(",");
        Arrays.stream(splittedMoney).forEach(split -> split = split.replaceAll("\\D++", ""));
        moneyIn = Integer.valueOf(splittedMoney[0]);
        centsIn = Integer.valueOf(splittedMoney[1]);

    }

    private void prepareCoins() {
        for (int i = 0; i <= Coin.values().length; i++) {
            coins.add(0);
        }
    }

    private void moneyIntoCoins() {
        int coin = 0;

        while (moneyIn > 0) {
            if (moneyIn % Coin.TWO_EURO.getValue() == 0) {
                coins.add(0, coin + 1);
                moneyIn -= Coin.TWO_EURO.getValue();
            } else if (moneyIn % Coin.ONE_EURO.getValue() == 0) {
                coins.add(1, coin + 1);
                moneyIn -= Coin.ONE_EURO.getValue();
            }
        }

        while (centsIn > 10) {
            if (centsIn % Coin.FIFTY_CENT.getValue() == 0) {
                coins.add(2, coin + 1);
                centsIn -= Coin.FIFTY_CENT.getValue();
            }
        }
    }

    private void countCoins() {
        coins.forEach(coin -> sum += coin);
    }

    public List<Integer> getCoins() {
        return coins;
    }

    public int getSum() {
        return sum;
    }

    public int getMoneyIn() {
        return moneyIn;
    }

    public int getCentsIn() {
        return centsIn;
    }

    @Override
    public String toString() {
        return sum + " coins.";
    }

}
