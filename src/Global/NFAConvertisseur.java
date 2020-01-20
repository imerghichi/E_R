package Global;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class NFAConvertisseur {
    private static int compteur_nouveau_etats= 0;

    private int getIndex_vecteur(Vector<NFAClosure> vector, NFAClosure nfaClosure){
     /* for (NFAClosure closure : vector){
            if (closure.equals(nfaClosure)) return closure.hashCode() ;
        }*/
       for (int i=0; i<vector.size();i++){
           if(vector.get(i).equals(nfaClosure)) return i;
       }
       return -1;
    }
    private boolean exister(HashSet<NFAClosure> nfaClosureSet, NFAClosure closure){
        Iterator<NFAClosure> closureIterator = nfaClosureSet.iterator();
        while (closureIterator.hasNext()){
            if(closure.equals((NFAClosure)closureIterator.next()))return true;
        }
        return false;
    }
    private void mlinimiser (Transition transition, Vector<Etat> etats){

    }

    public DFA convertisseur (NFAEpsilon nfaEpsilon){
        Vector<NFAClosure> pile_closure = new Vector<NFAClosure>();
        HashSet<NFAClosure> passe = new HashSet<NFAClosure>();
        Vector<NFAClosure> nouvelle_closure = new Vector<NFAClosure>();
        Vector<Etat> nouveaux_etats = new Vector<Etat>();
        Alphabet alphabet =nfaEpsilon.getAlphabet();
        DFA dfa = new DFA(40);
        Transition transition = new Transition(40);
        NFAClosure closure_initiale = new NFAClosure();

        closure_initiale.nouvelle_closure(nfaEpsilon.getInitial_etat(), nfaEpsilon);

        pile_closure.add(closure_initiale);

        passe.add(closure_initiale);

        int x = compteur_nouveau_etats++;
        if (closure_initiale.isAccepter() && closure_initiale.isInitial()){
            nouvelle_closure.add(closure_initiale);
            nouveaux_etats.add(new Etat(x,true,true));
        }
        else {
            if(closure_initiale.isInitial()){
                nouvelle_closure.add(closure_initiale);
                nouveaux_etats.add(new Etat(true,x));
            }
            else{
                if(closure_initiale.isAccepter()){
                    nouvelle_closure.add(closure_initiale);
                    nouveaux_etats.add(new Etat(x,true));
                }
                else{
                    nouvelle_closure.add(closure_initiale);
                    nouveaux_etats.add(new Etat(x));
                }
            }
        }
        dfa.ajouter_etat(nouveaux_etats.get(getIndex_vecteur(nouvelle_closure,closure_initiale)));

        for(int i = 0;i < pile_closure.size();i++){
            NFAClosure closure = pile_closure.get(i);

            for(int j=0; j< alphabet.compter_alphabet();j++){
                Vector<Etat> mapping = new Vector<Etat>();
                NFAClosure nfaClosure = new NFAClosure();

                Symbol input= alphabet.getAlphabet().get(j);

                mapping= nfaEpsilon.getMappingSymbol(closure, input);

                nfaClosure.closures(mapping,nfaEpsilon);

                if(!exister(passe,nfaClosure) && nfaClosure != null){
                    pile_closure.add(nfaClosure);
                    x=compteur_nouveau_etats++;
                    if(nfaClosure.isAccepter() && nfaClosure.isInitial()){
                        nouvelle_closure.add(nfaClosure);
                        nouveaux_etats.add(new Etat(x,true,true));

                    }
                    else{
                        if(nfaClosure.isInitial()){
                            nouvelle_closure.add((nfaClosure));
                            nouveaux_etats.add(new Etat(true,x))
                        }
                        else {
                            if(nfaClosure.isAccepter()){
                                nouvelle_closure.add(nfaClosure);
                                nouveaux_etats.add(new Etat(x,true));
                            }
                            else{
                                nouvelle_closure.add(nfaClosure);
                                nouveaux_etats.add(new Etat(x));
                            }
                        }
                    }
                    transition.ajouter(new Arc(nouveaux_etats.get(nouvelle_closure.indexOf(closure)),nouveaux_etats.get(nouvelle_closure.indexOf(closure)),input));
                }
                else{
                    if(closure.equals(nfaClosure)) transition.ajouter(new Arc((nouveaux_etats.get(getIndex_vecteur(nouvelle_closure,closure))),nouveaux_etats.get(getIndex_vecteur(nouvelle_closure,closure)),input));
                    else transition.ajouter(new Arc(nouveaux_etats.get(getIndex_vecteur(nouvelle_closure,closure)), nouveaux_etats.get(getIndex_vecteur(nouvelle_closure,nfaClosure)),input));
                }
            }
        }
        //minimiser

    }
}
