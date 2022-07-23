package monedas;

public enum Coin {
    
    TWO_EURO(2,0),
    ONE_EURO(1,1),
    FIFTY_CENT(50,2),
    TWENTY_CENT(20,3),
    TEN_CENT(10,4);
    

    int value;
    int order;
    private Coin(int value, int order){
        this.value = value;
        this.order = order;
    }

    public int getValue() {
        return value;
    }

    public int getOrder() {
        return order;
    }
    
}
