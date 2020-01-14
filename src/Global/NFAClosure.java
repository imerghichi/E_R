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
        Vector<Arc> vector = nfaEpsilon.getNFATransition().getVectorarc(etat);
        closure.add(etat);
        for(Arc arc : vector){
            if (arc.getLabel().contenir(EPSILON)){
                nouvelle_closure(arc.getDestination(),nfaEpsilon);
            }
        }
        if(etat.getIndexe() == nfaEpsilon.getAccepter_etat().getIndexe()) accepter = true;
        if(etat.getIndexe() == nfaEpsilon.getInitial_etat().getIndexe()) initial = true;
    }

    public void closures (Vector<Etat> etatVector, NFAEpsilon nfaEpsilon){
        for(Etat etat : etatVector){
            nouvelle_closure(etat,nfaEpsilon);
        }
    }

    public Vector<Etat> getClosure() {
        return closure;
    }

    public void setClosure(Vector<Etat> closure) {
        this.closure = closure;
    }

    public boolean isAccepter() {
        return accepter;
    }

    public void setAccepter(boolean accepter) {
        this.accepter = accepter;
    }

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }
    public boolean etat_exister(Etat etat){
        for (Etat etat1 : closure){
            if (etat1.getIndexe() == etat.getIndexe()) return true;
        }
        return false;
    }

    public boolean equals(NFAClosure nfaClosure) {
        if (closure.size() == nfaClosure.getClosure().size()){
            for (Etat etat : closure){
                if (! nfaClosure.etat_exister(etat)) return false;
            }
            return true;
        }
        return false;
    }
}
