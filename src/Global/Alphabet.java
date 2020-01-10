package Global;

import java.util.Vector;

public class Alphabet {
    private Vector<Symbol> alphabet;

    public Vector<Symbol> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Vector<Symbol> alphabet) {
        this.alphabet = alphabet;
    }

    public Alphabet() {
        alphabet = new Vector<Symbol>();
    }

    // mes méthodes

    public void ajouter (Symbol a){
        alphabet.add(a);
    }

    public int compter_alphabet(){
        return alphabet.size();
    }

    public boolean exister_symbol(Symbol s){
        for (int i =0; i<compter_alphabet();i++){
            if(alphabet.get(i).contenir(s.getSymbol()))
                return true;
        }
        return false;
    }
}
