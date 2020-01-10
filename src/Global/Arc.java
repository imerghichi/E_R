package Global;

public class Arc {
    private Etat source;
    private Etat destination;
    private Label label;

    //constructeurs
    public Arc() {
    }

    public Arc(Etat source, Etat destination, Label label) {
        this.source = source;
        this.destination = destination;
        this.label = label;
    }

    //getters setters
    public Etat getSource() {
        return source;
    }

    public void setSource(Etat source) {
        this.source = source;
    }

    public Etat getDestination() {
        return destination;
    }

    public void setDestination(Etat destination) {
        this.destination = destination;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    //mes méthodes
    public boolean est_identique(){
        if (source.getIndexe()==destination.getIndexe()) return true;
        return false;
    }
    public boolean contenir(char s){
        return label.contenir(s);
    }

    @Override
    public String toString() {
        return source +"----" +(Symbol)label+"---"+ destination;

    }
}
