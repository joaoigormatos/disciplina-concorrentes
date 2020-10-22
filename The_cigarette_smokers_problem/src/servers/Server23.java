package servers;

import com.sun.security.ntlm.Server;

import java.util.concurrent.Semaphore;

public class Server23 extends Thread{


    private Semaphore s2;
    private Semaphore s3;

    public Server23(Semaphore s2, Semaphore s3){
        this.s2 = s2;
        this.s3 = s3;
    }



    @Override
    public void run() {
        try{
            System.out.println("Servidor23 bloqueou recurso 2");

            s2.acquire();
            Thread.sleep(2000);
            System.out.println("Servidor23 liberou recurso 2");
            s2.release();

            System.out.println("Servidor23 bloqueou recurso 3");

            s3.acquire();
            Thread.sleep(2000);
            System.out.println("Servidor23 liberou recurso 3");
            s3.release();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
