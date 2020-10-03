package Workers;

import Section.CoreSection;

public class WorkerQ extends Thread {
    private CoreSection coreSection;
    public WorkerQ(CoreSection coreSection){
        this.coreSection = coreSection;
    }
    @Override
    public void run() {

        try {
            while(true){
                System.out.println("WorkerQ on non critical section");
                Thread.sleep(5000);

                if(coreSection.getTurn()==2){
                    System.out.println("WorkerQ entering into critical section");
                    Thread.sleep(5000);
                    coreSection.setTurn(1);
                    System.out.println("WorkerP leaving  from  critical section");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
