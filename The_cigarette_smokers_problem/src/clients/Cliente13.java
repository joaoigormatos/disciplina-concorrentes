package clients;

import java.util.concurrent.Semaphore;

public class Cliente13 extends Thread {


    private Semaphore s1;
    private Semaphore s3;


    public Cliente13(Semaphore s1, Semaphore s3){
        this.s1 = s1;
        this.s3 = s3;
    }



    @Override
    public void run() {
        try{
            System.out.println("Cliente13 esperando recurso 1");
            s1.acquire();
            System.out.println("Cliente13 usou recurso 1");
            s1.release();


            System.out.println("Cliente13 esperando recurso 3");
            s3.acquire();
            System.out.println("Cliente13 usou recurso 3");
            s3.release();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
