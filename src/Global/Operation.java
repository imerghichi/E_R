package Global;

public class Operation {
    private static final char EPSILON = '$';

    static public NFAEpsilon plus (NFAEpsilon nfaEpsilon){
        NFAEpsilon nfaEpsilon1 =new NFAEpsilon();
        NFATransition transition = new NFATransition(40);
        nfaEpsilon1.setInitial_etat(nfaEpsilon.getInitial_etat());
        nfaEpsilon1.setAccepter_etat(nfaEpsilon.getAccepter_etat());
        transition = nfaEpsilon.getNFATransition();
        transition.ajouter(new Arc(nfaEpsilon.getAccepter_etat(),nfaEpsilon.getInitial_etat(),new Symbol(EPSILON)));
        nfaEpsilon1.ajouter_etats(nfaEpsilon.getEtatSet());
        nfaEpsilon1.setTransition(transition);
        return nfaEpsilon1;
    }

    static public NFAEpsilon etoile (NFAEpsilon nfaEpsilon){
        NFAEpsilon A = new NFAEpsilon();
        NFATransition transition = new NFATransition(40);

        A.setInitial_etat(new Etat(false,true));
        A.setAccepter_etat(new Etat(true, false));

        transition = nfaEpsilon.getNFATransition();
        transition.ajouter(new Arc(A.getInitial_etat(),nfaEpsilon.getInitial_etat(),new Symbol(EPSILON)));
        transition.ajouter(new Arc(A.getInitial_etat(),A.getAccepter_etat(), new Symbol(EPSILON)));
        transition.ajouter(new Arc(nfaEpsilon.getAccepter_etat(), nfaEpsilon.getInitial_etat(), new Symbol(EPSILON)));
        transition.ajouter(new Arc(nfaEpsilon.getAccepter_etat(),A.getAccepter_etat(), new Symbol(EPSILON)));

        A.setTransition(transition);
        A.ajouter_etats(nfaEpsilon.getEtatSet());

        return A;
    }

    static public NFAEpsilon produit (NFAEpsilon A, NFAEpsilon B){
        NFATransition transition = new NFATransition(40);

        NFAEpsilon C = new NFAEpsilon();
        C.setInitial_etat(A.getInitial_etat());
        C.setAccepter_etat(B.getAccepter_etat());

        transition = A.getNFATransition();
        transition.ajouter_tout_transition(B.getNFATransition());
        transition.setDestination(A.getAccepter_etat(),B.getInitial_etat());

        C.setTransition(transition);
        C.ajouter_etats(A.getEtatSet());
        C.ajouter_etats(B.getEtatSet());
        C.modifier_etat(A.getAccepter_etat(),B.getInitial_etat());

        return C;
    }

    static private NFAEpsilon union (NFAEpsilon A, NFAEpsilon B){
        NFATransition transition = new NFATransition(40);

        NFAEpsilon C = new NFAEpsilon();

        C.setInitial_etat(new Etat(false, true));
        C.setAccepter_etat(new Etat(true,false));

        transition= A.getNFATransition();
        transition.ajouter_tout_transition(B.getNFATransition());
        C.ajouter_etats(A.getEtatSet());
        C.ajouter_etats(B.getEtatSet());

        transition.ajouter(new Arc(C.getInitial_etat(),A.getInitial_etat(),new Symbol(EPSILON)));
        transition.ajouter(new Arc(C.getInitial_etat(),B.getInitial_etat(),new Symbol(EPSILON)));
        transition.ajouter(new Arc(A.getAccepter_etat(),C.getAccepter_etat(), new Symbol(EPSILON)));
        transition.ajouter(new Arc(B.getAccepter_etat(),C.getAccepter_etat(), new Symbol(EPSILON)));

        C.setTransition(transition);

        return C;
    }


}
