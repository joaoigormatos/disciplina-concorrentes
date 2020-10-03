package Wokers;

import Section.CoreSection;

public class WokerP extends Thread {

    @Override
    public void run() {

        try {
            CoreSection coreSection = CoreSection.getInstance();
            while(true){
                System.out.println("WorkP is on non-critical section");
                Thread.sleep(5000);
                if(coreSection.getWantQ()==false){
                    coreSection.setWantP(true);
                    System.out.println("WorkP wants to enter on the critical section");
                    coreSection.setWantP(true);
                    Thread.sleep(5000);
                    System.out.println("WorkP is on critical section");

                    Thread.sleep(5000);
                    System.out.println("WorkP leaving from critical section");
                    coreSection.setWantP(false);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
