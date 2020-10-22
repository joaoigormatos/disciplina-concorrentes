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
            //1- CLIENTE13 esperando permissão do semaforo para usar recurso 1
            s1.acquire();  
            //2- SEMAFORO blocante recurso 1 para outros clientes e deixando o CLIENTE13 usar o recurso 1;
            System.out.println("Cliente13 usou recurso 1");
            s1.release();
            //3- SEMAFORO Liberando recurso 1 para outros clientes usa-lo;
            System.out.println("Cliente13 esperando recurso 3");
            //4- CLIENTE13 esperando permissão do semaforo para recurso 3;
            s3.acquire();
            //5- SEMAFORO blocante recurso 3 para outros clientes e deixando o CLIENTE13 usar o recurso 3;
            System.out.println("Cliente13 usou recurso 3");
            s3.release();
            //6- SEMAFORO Liberando recurso 3 para outros clientes usa-lo;

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
