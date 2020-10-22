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
            
            s1.acquire(); //1- SEMAFORO blocante recurso 1 para apenas um cliente usar o recurso 1;
            Thread.sleep(2000);
            System.out.println("Servidor12 liberou recurso 1");
            s1.release(); //2- SEMAFORO Liberando recurso 1 para outro cliente usa-lo;

            System.out.println("Servidor12  bloqueou recurso 2");
            s2.acquire(); //3- SEMAFORO blocante recurso 2 para apenas um cliente usar o recurso 2;
            Thread.sleep(2000);
            System.out.println("Servidor12 liberou recurso 2");
            s2.release();//4 - SEMAFORO Liberando recurso 2 para outro cliente usa-lo;

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
