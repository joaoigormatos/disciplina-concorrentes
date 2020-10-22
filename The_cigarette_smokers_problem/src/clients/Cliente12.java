package clients;

import java.util.concurrent.Semaphore;

public class Cliente12 extends Thread {


    private Semaphore s1;
    private Semaphore s2;


    public Cliente12(Semaphore s1, Semaphore s2){
        this.s1 = s1;
        this.s2 = s2;
    }



    @Override
    public void run() {
        try{
            System.out.println("Cliente12 esperando recurso 1");
            s1.acquire();
            System.out.println("Cliente12 usou recurso 1");
            s1.release();

            System.out.println("Cliente12 esperando recurso 2");
            s2.acquire();
            System.out.println("Cliente12 usou recurso 2");
            s2.release();


        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
