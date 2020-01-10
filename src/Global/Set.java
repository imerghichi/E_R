package Global;

public class Set implements Label {
    private String symbols;

    public Set(String symbols) {
        this.symbols = symbols;
    }

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public boolean contenir(char s) {
        return (symbols.indexOf(s)>=0);
    }
}
