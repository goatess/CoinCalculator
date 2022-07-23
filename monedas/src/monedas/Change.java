package monedas;

import java.util.ArrayList;
import java.util.List;

public class Change {
    List<Integer> coins = new ArrayList<>();

    public Change(int moneyIn) {
        prepareCoins();
        moneyIntoCoins(moneyIn);
    }


    private void prepareCoins(){
        for(int i = 0; i < Coin.values().length; i++){
            coins.add(0);
        }
    }
    private void moneyIntoCoins(int moneyIn) {

        int coin = 1;
        while (moneyIn > 1) {
            if (moneyIn % Coin.TWO_EURO.getValue() == 0) {
                coins.add(0, coin++);
                moneyIn -= Coin.TWO_EURO.getValue();
            } else if (moneyIn % Coin.ONE_EURO.getValue() == 0) {
                coins.add(1, coin++);
                moneyIn -= Coin.ONE_EURO.getValue();
            }

        }
       
            
    }

    public List<Integer> getCoins() {
        return coins;
    }

}
