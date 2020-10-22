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
            //1- CLIENTE12 esperando permissão do semaforo para usar recurso 1
            s1.acquire();
            //2- SEMAFORO blocante recurso 1 para outros clientes e deixando o CLIENTE12 usar o recurso 1;
            System.out.println("Cliente12 usou recurso 1");
            s1.release();
            //3- SEMAFORO Liberando recurso 1 para outros clientes usa-lo;
            System.out.println("Cliente12 esperando recurso 2");
            //4- CLIENTE12 esperando permissão do semaforo para recurso 2;
            s2.acquire();
            //5- SEMAFORO blocante recurso 2 para outros clientes e deixando o CLIENTE12 usar o recurso 2;
            System.out.println("Cliente12 usou recurso 2");
            s2.release();
            //6- SEMAFORO Liberando recurso 2 para outros clientes usa-lo;


        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
