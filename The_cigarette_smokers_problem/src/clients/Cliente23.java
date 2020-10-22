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
            //1- CLIENTE23 esperando permissão do semaforo para usar recurso 2
            s2.acquire();
            //2- SEMAFORO blocante recurso 2 para outros clientes e deixando o CLIENTE23 usar o recurso 2;
            System.out.println("Cliente23 usou recurso 2");
            s2.release();
            //3- SEMAFORO Liberando recurso 2 para outros clientes usa-lo;
            System.out.println("Cliente23 esperando 3");
            //4- CLIENTE23 esperando permissão do semaforo para recurso 3;
            s3.acquire();
            //5- SEMAFORO blocante recurso 3 para outros clientes e deixando o CLIENTE23 usar o recurso 3;
            System.out.println("Cliente23 usou 3");
            s3.release();
            //6- SEMAFORO Liberando recurso 3 para outros clientes usa-lo;

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
