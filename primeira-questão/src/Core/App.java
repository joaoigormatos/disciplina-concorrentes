package Core;

import Section.CoreSection;
import Workers.WorkerP;
import Workers.WorkerQ;

public class App {
    public static void main(String[] args) {
        CoreSection coreSection = CoreSection.getInstance();
        WorkerP workerP = new WorkerP(coreSection);
        WorkerQ workerQ = new WorkerQ(coreSection);

        workerP.start();
        workerQ.start();
    }
}
