package core;

import clients.Cliente12;
import clients.Cliente13;
import clients.Cliente23;
import resources.Resource;
import servers.Server12;
import servers.Server13;
import servers.Server23;

import java.util.concurrent.Semaphore;

public class App {
    //Resources
    private static Resource resourceOne;
    private static Resource resourceTwo;
    private static Resource resourceThree;




    public static void run(){
        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);

        Server12 server12 = new Server12(semaphore,semaphore2);
        Server13 server13 = new Server13(semaphore,semaphore3);
        Server23 server23 = new Server23(semaphore2,semaphore3);

        Cliente12 cliente12 = new Cliente12(semaphore,semaphore2);
        Cliente13 cliente13 = new Cliente13(semaphore,semaphore3);
        Cliente23 cliente23 = new Cliente23(semaphore2,semaphore3);

        server12.start();
        server13.start();
        server23.start();

        cliente12.start();
        cliente13.start();
        cliente23.start();

        try {
            server12.join();
            server13.join();
            server23.join();

            cliente12.join();
            cliente13.join();
            cliente23.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //initializeResources();
    }

    private static void initializeResources(){
        resourceOne = new Resource("resourceOne");
        resourceTwo = new Resource("resourceTwo");
        resourceThree= new Resource("resourceThree");
    }
}
