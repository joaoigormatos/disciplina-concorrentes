package Section;

public class CoreSection {
    private static  CoreSection instance;
    private  int turn;

    private CoreSection(){
        this.turn = 1;
    }

    public static CoreSection getInstance() {
        if(instance==null){
            instance = new CoreSection();
        }
        return instance;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
