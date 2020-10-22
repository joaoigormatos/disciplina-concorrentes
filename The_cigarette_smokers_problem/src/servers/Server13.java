package servers;

import java.util.concurrent.Semaphore;

public class Server13 extends Thread{


    private Semaphore s1;
    private Semaphore s3;

    public Server13(Semaphore s1, Semaphore s3){
        this.s1 = s1;
        this.s3 = s3;
    }


    @Override
    public void run() {
        try{
            System.out.println("Servidor13 bloqueou recurso 1");
            s1.acquire();
            Thread.sleep(2000);

            System.out.println("Servidor13 liberou recurso 1");
            s1.release();

            System.out.println("Servidor13 bloqueou recurso 3");
            s3.acquire();
            Thread.sleep(2000);
            System.out.println("Servidor13 liberou recurso 3");
            s3.release();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
