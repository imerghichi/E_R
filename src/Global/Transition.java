package Global;

import java.util.Vector;

public class Transition {
    private Vector<Arc> T[];

    //constructor :(
    public Transition(int nombre) {
        T = new Vector[nombre];
        for (int i =0; i<nombre; i++){
            T[i] = new Vector<Arc>();
        }
    }

    public Vector<Arc>[] getT() {
        return T;
    }

    // remarquer vector arc n est pas liste de vecteurs ;)
    public void setVectorArc(int indexe, Vector<Arc> t) {
        T[indexe] = t;
    }
    public Vector<Arc> getVectorArc(int indexe) {
       return getT()[indexe];
    }

    public void supprimer_transition(int indexe){
        T[indexe].removeAllElements();
    }

    public boolean est_identique_transition(int i){
        boolean bcmp =true;
        for (int j =0; j<getVectorArc(i).size();j++){
            if (getVectorArc(i).get(j).est_identique()==false) bcmp= false;
        }
        return bcmp;
    }
    public void ajouter(Arc arc){
        //s il y a place? ...
        if (arc.getSource().getIndexe()<=T.length){
            T[arc.getSource().getIndexe()].add(arc);
        }
    }


}
