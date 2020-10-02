package workers;

import main.Controller;

public class ProcessQ  extends Thread{
	Controller controller = Controller.getInstance();
	
	private void myProcess() throws InterruptedException {
		while(true) {
			System.out.println("Process Q on the no-critical section");
			Thread.sleep((long) 1000);
			controller.setWantq(true);
			System.out.println("Process Q set wantq true");
			Thread.sleep((long) 1000);
			while(controller.isWantp()) {
				controller.setWantq(false);
				System.out.println("Process Q set wantq false");
				Thread.sleep((long) 1000);
				controller.setWantq(true);
				System.out.println("Process Q set wantq true");
				Thread.sleep((long) 1000);
			}
			System.out.println("Process Q on the critical section");
			Thread.sleep((long) 1000);
			System.out.println("Process Q leaves the critical section");
			Thread.sleep((long) 1000);
			controller.setWantq(false);
			System.out.println("Process Q set wantq false");
			Thread.sleep((long) 1000);
		}
	}
	@Override
	public void run() {
		try {
			myProcess();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
