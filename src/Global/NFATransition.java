package Global;

import java.util.Vector;

public class NFATransition {
    private Vector<Vector<Arc>> transition ;

    //constructeur selon nombre de vect
    public NFATransition(int nombre) {
        transition = new Vector<Vector<Arc>>();
        for (int i =0 ; i<nombre; i++){
            Vector<Arc> vector = new Vector<Arc>();
            transition.add(i,vector);
        }
    }

    public Vector<Vector<Arc>> getTransition() {
        return transition;
    }
    public Vector<Arc> getVectorarc(Etat etat){
        Vector<Vector<Arc>> vector = getTransition();
        Vector<Arc> arcVector = new Vector<Arc>();
        for(int i=0; i<vector.size(); i++){
            for (int j=0; j<vector.get(i).size();j++){
                if (vector.get(i).isEmpty()==false){
                    if(vector.get(i).get(0).getSource().getIndexe()==etat.getIndexe()){
                        arcVector= vector.get(i);
                    }
                }
            }
        }
        return arcVector;
    }
    public Vector<Arc> getVectorarc(int  indexe){
        return getTransition().get(indexe);
    }

    public NFATransition(Arc arc) {
        Vector<Arc> arcVector = new Vector<Arc>();
        arcVector.add(arc);
        transition.add(arc.getSource().getIndexe(),arcVector);
    }

    public void ajouter (Arc arc){
        transition.elementAt(arc.getSource().getIndexe()).add(arc);
    }
    public int compter_transition(){
        return transition.size();
    }
    public void ajouter_tout_transition(NFATransition nfaTransition){
        for (int i =0 ;i<nfaTransition.compter_transition(); i++){
            transition.add(i, nfaTransition.getVectorarc(i));
        }
    }

    //methode retourne les etats auquelles on peut acceder depuis un etat donne suivant un caractere donne
    public Vector<Etat> getEtatsAccessibles(Etat etat, char c){
        Vector<Arc> arcVector = getVectorarc(etat);
        Vector<Etat> etats =new Vector<Etat>();
        for (int i = 0 ; i < arcVector.size();i++){
            if (arcVector.get(i).getLabel().contenir(c)){
                etats.add(arcVector.get(i).getDestination());
            }
        }
        return etats;
    }

    //modification des source et  destination

    public void setSource(Etat ancien, Etat nouveau){
        if(ancien.getIndexe()<transition.size()){
            for (int i=0; i>transition.get(ancien.getIndexe()).size();i++){
                transition.get(ancien.getIndexe()).get(i).setSource(nouveau);
            }
        }
    }

    public void setDestination(Etat ancien, Etat nouveau){
      for (int i =0; i<transition.size(); i++){
          for(int j =0; j<transition.get(i).size();j++){
              if (transition.get(i).get(j).getDestination().getIndexe() == ancien.getIndexe()){
                  transition.get(i).get(j).setDestination(nouveau);
              }
          }
      }
    }
}
