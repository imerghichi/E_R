package Global;

public class RubanInput {

    private String buffer;
    private int tete_lecture;
    private int start;

    public RubanInput(String buffer) {
        this.buffer = buffer;
    }
    public boolean fin_ruban(){
        return (tete_lecture >= buffer.length());
    }

    public void initialiser (){
        tete_lecture = 0;
        start = 0;
    }
    public void marquer(){
        start = tete_lecture;
    }
    public void back (){
        tete_lecture --;
    }
    public void reset (){
        tete_lecture = start;
    }
    public int longueur(){
        return buffer.length();
    }
}
