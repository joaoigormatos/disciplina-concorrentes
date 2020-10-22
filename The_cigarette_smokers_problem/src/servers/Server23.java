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

            s2.acquire(); //1- SEMAFORO blocante recurso 1 para apenas um cliente usar o recurso 1;
            Thread.sleep(2000);
            System.out.println("Servidor23 liberou recurso 2");
            s2.release();//2- SEMAFORO Liberando recurso 2 para outro cliente usa-lo;

            System.out.println("Servidor23 bloqueou recurso 3");

            s3.acquire(); //3- SEMAFORO blocante recurso 3 para apenas um cliente usar o recurso 3;
            Thread.sleep(2000);
            System.out.println("Servidor23 liberou recurso 3");
            s3.release();//4- SEMAFORO Liberando recurso 3 para outro cliente usa-lo;

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
