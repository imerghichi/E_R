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
    public char getNextSymbol(){
        if (fin_ruban()) return (char) 0;
        char c = buffer.charAt(tete_lecture);
        tete_lecture++;
        return c;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public int getTete_lecture() {
        return tete_lecture;
    }

    public void setTete_lecture(int tete_lecture) {
        this.tete_lecture = tete_lecture;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
