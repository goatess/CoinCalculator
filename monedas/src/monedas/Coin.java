package monedas;

public enum Coin {
    
    TWO_EURO(200,0),
    ONE_EURO(100,1),
    FIFTY_CENT(50,2),
    TWENTY_CENT(20,3),
    TEN_CENT(10,4),
    FIVE_CENT(5,5),
    TWO_CENT(2,6),
    ONE_CENT(1,7);
    

    private int valueInCents;
    private int order;

    private Coin(int valueInCents, int order){
        this.valueInCents = valueInCents;
        this.order = order;
    }

    public int getValueInCents() {
        return valueInCents;
    }

    public int getOrder() {
        return order;
    }
}
