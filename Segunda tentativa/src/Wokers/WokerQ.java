package Wokers;

import Section.CoreSection;

public class WokerQ extends Thread {

    @Override
    public void run() {

        try {
            CoreSection coreSection = CoreSection.getInstance();
            while(true){
                System.out.println("WorkQ is on non-critical section");
                Thread.sleep(5000);
                if(coreSection.getWantP()==false){
                    coreSection.setWantQ(true);
                    System.out.println("WorkQ wants to enter on the critical section");
                    coreSection.setWantQ(true);
                    Thread.sleep(5000);
                    System.out.println("WorkQ is on critical section");

                    Thread.sleep(5000);
                    System.out.println("WorkQ leaving from critical section");
                    coreSection.setWantQ(false);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
