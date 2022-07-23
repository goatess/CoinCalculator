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
        if (splittedMoney[1].length() > 2) {
            splittedMoney[1].subSequence(0, 2);
        }
        if (splittedMoney[1].length() < 2) {
            centsIn = Integer.valueOf(splittedMoney[1]) * 10;
        } else
            centsIn = Integer.valueOf(splittedMoney[1]);

    }

    private void prepareCoins() {
        for (int i = 0; i <= Coin.values().length; i++) {
            coins.add(0);
        }
    }

    private void moneyIntoCoins() {

        for (Coin value : Coin.values()) {
            int coinsAmount = 0;
            int coinValue = value.getValue();

            if (value.getOrder() > 1) {
                while (centsIn >= coinValue) {
                    coinsAmount++;
                    centsIn -= coinValue;
                    if (centsIn < coinValue) {
                        coins.add(value.getOrder(), coinsAmount);
                        break;
                    }
                }
            } else {
                while (moneyIn >= coinValue) {
                    coinsAmount++;
                    moneyIn -= coinValue;
                    if (moneyIn < coinValue) {
                        coins.add(value.getOrder(), coinsAmount);
                        break;
                    }
                }
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
        String two = "(" + coins.get(0) + ") 2 euro coins, ";
        String one = "(" + coins.get(1) + ") 1 euro coins, ";
        String fifty = "(" + coins.get(2) + ") 50 cents coins, ";
        String twenty = "(" + coins.get(3) + ") 20 cents coins, ";
        String ten = "(" + coins.get(4) + ") 10 cent coins, ";
        return sum + " coins. " + two + one + fifty + twenty + ten;
    }

}
