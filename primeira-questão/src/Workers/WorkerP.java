package Workers;

import Section.CoreSection;

public class WorkerP extends Thread {
    private CoreSection coreSection;
    public WorkerP(CoreSection coreSection){
        this.coreSection = coreSection;
    }
    @Override
    public void run() {

        try {
            while(true){
                System.out.println("WorkerP on non critical section");
                Thread.sleep(5000);

                if(coreSection.getTurn()==1){
                    System.out.println("WorkerP entering into critical section");
                    Thread.sleep(5000);
                    coreSection.setTurn(2);
                    System.out.println("WorkerP leaving  from  critical section");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
