package servers;

import resources.Resource;

import java.util.concurrent.Semaphore;

public class Server12 extends Thread{


    private Semaphore s1;
    private Semaphore s2;
    
    public Server12(Semaphore s1, Semaphore s2){
        this.s1 = s1;
        this.s2 = s2;
    }



    @Override
    public void run() {
        try{
            System.out.println("Servidor12  bloqueou recurso 1");
            s1.acquire();
            Thread.sleep(2000);
            System.out.println("Servidor12 liberou recurso 1");
            s1.release();

            System.out.println("Servidor12  bloqueou recurso 2");
            s2.acquire();
            Thread.sleep(2000);
            System.out.println("Servidor12 liberou recurso 2");
            s2.release();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
