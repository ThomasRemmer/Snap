public class Card {
    protected String suit;
    protected String symbol;
    protected int value;
    public Card(String suit, String symbols, int value){
        this.suit = suit;
        this.symbol = symbols;
        this.value = value;
    }

    public String getSuit() {
        return this.suit;
    }
    public String getSymbol() {
        return this.symbol;
    }
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return getSymbol() + " of " + getSuit();
    }

}
