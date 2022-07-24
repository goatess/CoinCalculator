package monedas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    private int moneyIn;
    private int centsIn;
    private int sum = 0;
    private List<Integer> coins = new ArrayList<>();

    public Change(String moneyIn) {
        splitMoney(moneyIn);
        countCoins();
        sumCoins();
    }

    public Change(int moneyIn) {
        centsIn = moneyIn * 100;
        countCoins();
        sumCoins();
    }

    public Change(float moneyIn) {
        moneyIn = moneyIn * 100;
        centsIn = Math.round(moneyIn);
        countCoins();
        sumCoins();
    }

    private void splitMoney(String money) {
        String[] splittedMoney = new String[2];
        splittedMoney = money.split(",");
        Arrays.stream(splittedMoney).forEach(split -> split = split.replaceAll("\\D++", ""));
        convertToCents(splittedMoney);
    }

    private void convertToCents(String[] splittedMoney) {
        moneyIn = Integer.valueOf(splittedMoney[0]) * 100;
        if (splittedMoney.length < 2)
            centsIn = 0;
        else {
            splittedMoney[1] = splittedMoney[1] + 0;
            splittedMoney[1] = splittedMoney[1].substring(0, 2);
            centsIn = Integer.valueOf(splittedMoney[1]);
        }
        centsIn += moneyIn;
    }

    private void countCoins() {
        for (Coin value : Coin.values()) {
            int coinsAmount = 0;
            int coinValue = value.getValueInCents();

            while (centsIn >= coinValue) {
                coinsAmount++;
                centsIn -= coinValue;
            }
            coins.add(coinsAmount);
        }
    }

    private void sumCoins() {
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
        String coinsAmounts = "";
        String coinAmount = "";
        int i = 0;
        for (Coin value : Coin.values()) {
            if (coins.get(i) != 0) {
                coinAmount = "(" + coins.get(i) + ") " + value + " coins, ";
                coinsAmounts += coinAmount;
            }
            i++;
        }
        return sum + " coins. " + coinsAmounts;
    }
}
