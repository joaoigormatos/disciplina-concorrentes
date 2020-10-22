package clients;

import java.util.concurrent.Semaphore;

public class Cliente23 extends Thread {


    private Semaphore s2;
    private Semaphore s3;


    public Cliente23(Semaphore s2, Semaphore s3){
        this.s2 = s2;
        this.s3 = s3;
    }



    @Override
    public void run() {
        try{
            System.out.println("Cliente23 esperando recurso 2");
            s2.acquire();
            System.out.println("Cliente23 usou recurso 2");
            s2.release();

            System.out.println("Cliente23 esperando 3");
            s3.acquire();
            System.out.println("Cliente23 usou 3");
            s3.release();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
