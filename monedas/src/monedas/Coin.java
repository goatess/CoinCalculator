package monedas;

public enum Coin {
    
    TWO_EURO(2),
    ONE_EURO(1),
    FIFTY_CENT(50);
    

    int value;
    private Coin(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
