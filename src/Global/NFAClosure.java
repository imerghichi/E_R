package Global;

import java.util.Vector;

public class NFAClosure {
    private static final char EPSILON = '$';
    private Vector<Etat> closure;
    private boolean accepter= false;
    private boolean initial = false;

    public NFAClosure() {
        closure =new Vector<Etat>();
    }

    // l etat source est inclu dans sa closure
    public void nouvelle_closure ( Etat etat, NFAEpsilon nfaEpsilon){
        Vector<Arc> vector = nfaEpsilon.getTransition().getVectorArc(etat);
    }
}
