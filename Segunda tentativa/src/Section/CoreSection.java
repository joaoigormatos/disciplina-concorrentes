package Section;

public class CoreSection {
    private static CoreSection coreSection;
    private boolean wantQ;
    private boolean wantP;

    private CoreSection(){
        wantP = false;
        wantP = false;
    }

    public static  CoreSection getInstance(){
        if(coreSection== null)
            coreSection = new CoreSection();
        return coreSection;
    }
    public boolean getWantP(){
        return wantP;
    }
    public boolean getWantQ(){
        return wantQ;
    }
    public void setWantP(boolean wantP) {
        this.wantP = wantP;
    }

    public void setWantQ(boolean wantQ) {
        this.wantQ = wantQ;
    }
}
