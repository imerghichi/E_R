package Global;

public class Etat {
    private static int compteur =0;
    private int indexe;
    private boolean accepter = false;
    private boolean initial = false;
    private String nom =null;

    public Etat() {
        indexe = compteur++; // compteur incremente est indexe recoit compteur
    }

    public Etat(boolean accepter, boolean initial) {
        indexe = compteur++;
        this.accepter = accepter;
        this.initial = initial;
    }

    public Etat(int indexe, boolean accepter, boolean initial) {
        this.indexe = indexe;
        this.accepter = accepter;
        this.initial = initial;
        compteur++;
    }

    public Etat(int indexe) {
        this.indexe = indexe;
        compteur++;
    }

    public Etat( boolean initial,int indexe) {
        this(indexe);
        this.accepter = initial;
    }

    //switcher les arguments car meme type

    public Etat(int indexe, boolean accepter) {
        this(indexe);
        this.accepter = accepter;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Etat.compteur = compteur;
    }

    public int getIndexe() {
        return indexe;
    }

    public void setIndexe(int indexe) {
        this.indexe = indexe;
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
    //getter

    public String getNom() {
        if (nom == null){
            nom ="q"+ getIndexe();
        }
        return nom;
    }


    //toString


    @Override
    public String toString() {
        if (accepter) return "(("+indexe+"))";
        if (initial) return "[["+indexe+"]]";
        return "("+indexe+")";
    }
}
