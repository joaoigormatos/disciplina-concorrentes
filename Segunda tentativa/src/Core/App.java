package Core;

import Wokers.WokerP;
import Wokers.WokerQ;

public class App {
    public static void main(String[] args) {
        WokerP wokerP = new WokerP();
        WokerQ wokerQ = new WokerQ();
        wokerP.start();
        wokerQ.start();
    }
}
