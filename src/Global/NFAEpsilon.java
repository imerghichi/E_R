package Global;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class NFAEpsilon extends DFA {
    //set de java util pas set dans global
    private Set<Etat> etatSet;
    private Etat initial_etat;
    private Etat accepter_etat;
    private NFATransition transition;
    private Alphabet alphabet;

    public Set<Etat> getEtatSet() {
        return etatSet;
    }

    public void setEtatSet(Set<Etat> etatSet) {
        this.etatSet = etatSet;
    }

    public Etat getInitial_etat() {
        return initial_etat;
    }

    public void setInitial_etat(Etat initial_etat) {
        this.initial_etat = initial_etat;
    }

    public Etat getAccepter_etat() {
        return accepter_etat;
    }

    public void setAccepter_etat(Etat accepter_etat) {
        this.accepter_etat = accepter_etat;
    }

    public void setTransition(NFATransition transition) {
        this.transition = transition;
    }

    public NFAEpsilon(Symbol symbol) {
        etatSet = new HashSet<Etat>();
        transition = new NFATransition(40);
        setInitial_etat(new Etat(false,true));
        setAccepter_etat(new Etat(true,false));
        Arc arc = new Arc(getInitial_etat(),getAccepter_etat(),symbol);
        transition.ajouter(arc);
    }

    public NFAEpsilon() {
        etatSet = new HashSet<Etat>();
        transition = new NFATransition(40);
    }

    @Override
    public void ajouter_etat(Etat etat) {
        etatSet.add(etat);
    }

    public void ajouter_etats(Set<Etat> etatSet){
        ensemble_etats.addAll(etatSet);
    }
    public void ajouter_arc(Etat source, Etat destination, char start){


    }
}
