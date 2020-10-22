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
            s1.acquire(); //1- SEMAFORO blocante recurso 1 para apenas um cliente usar o recurso 1;
            Thread.sleep(2000);

            System.out.println("Servidor13 liberou recurso 1");
            s1.release();//2- SEMAFORO Liberando recurso 1 para outro cliente usa-lo;

            System.out.println("Servidor13 bloqueou recurso 3");
            s3.acquire();//3- SEMAFORO blocante recurso 3 para apenas um cliente usar o recurso 3;
            Thread.sleep(2000);
            System.out.println("Servidor13 liberou recurso 3");
            s3.release();//4- SEMAFORO Liberando recurso 3 para outro cliente usa-lo;

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
