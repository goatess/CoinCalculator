package monedas;

public enum Coin {
    
    TWO_EURO(2),
    ONE_EURO(1);
    

    int value;
    private Coin(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
