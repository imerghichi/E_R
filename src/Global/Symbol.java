package Global;

public class Symbol implements Label {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return " " + symbol;
    }

    @Override
    public boolean contenir(char s) {
        return (s==symbol);
    }
}
