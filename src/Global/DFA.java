package Global;

import java.util.Vector;

public class DFA {
    public Vector<Etat> ensemble_etats;
    public Transition transition;
    private Alphabet alphabet;

    //constructeur nbre d etats inconnu
    public DFA() {
        transition = new Transition(40);//nombre assez grand?
        ensemble_etats = new Vector<Etat>();
    }
    //nombre d etats connu
    public DFA(int nombre_etats) {
        transition = new Transition(nombre_etats);//nombre assez grand?
        ensemble_etats = new Vector<Etat>(nombre_etats);
    }

    public Vector<Etat> getEnsemble_etats() {
        return ensemble_etats;
    }

    public void setEnsemble_etats(Vector<Etat> ensemble_etats) {
        this.ensemble_etats = ensemble_etats;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    //mes methodes
    public void setAccepter(int etat, boolean accepter){
        ensemble_etats.get(etat).setAccepter(accepter);
    }
    public void ajouter_arc(int source, int destination, char start){
        Arc arc = new Arc(ensemble_etats.get(source),ensemble_etats.get(destination), new Symbol(start));
        transition.ajouter(arc);
    }
    public void ajouter_arc(Arc arc){
        transition.ajouter(arc);
    }
    public void ajouter_etat(Etat etat){
        ensemble_etats.add(etat);
    }

}
