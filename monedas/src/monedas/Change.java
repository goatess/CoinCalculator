package monedas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    private int moneyIn;
    private int centsIn;
    private int sum = 0;
    private List<Integer> coins = new ArrayList<>();

    public Change(String money) {
        splitMoney(money);
        centsIntoCoins();
        countCoins();
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
        else
            centsIn = Integer.valueOf(splittedMoney[1]);
        centsIn += moneyIn;
    }

    private void centsIntoCoins() {
        for (Coin value : Coin.values()) {
            int coinsAmount = 0;
            int coinValue = value.getValueInCents();
            while (centsIn >= coinValue) {
                coinsAmount++;
                centsIn -= coinValue;
            }
            coins.add(value.getOrder(), coinsAmount);
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
        String ten = "(" + coins.get(4) + ") 10 cents coins, ";
        String fiveC = "(" + coins.get(5) + ") 5 cents coins, ";
        String twoC = "(" + coins.get(6) + ") 2 cents coins, ";
        String oneC = "(" + coins.get(7) + ") 1 cent coins.";
        return sum + " coins. " + two + one + fifty + twenty + ten + fiveC + twoC + oneC;
    }

}
