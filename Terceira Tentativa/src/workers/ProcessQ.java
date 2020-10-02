package workers;

import main.Controller;

public class ProcessQ extends Thread{
	Controller controller = Controller.getInstance();
	
	private void myProcess() throws InterruptedException {
		while(true) {
			System.out.println("Process Q on non-critical section");
			Thread.sleep((long) 1000);
			System.out.println("Process Q set Wantq true");
			controller.setWantq(true);
			Thread.sleep((long) 1000);
			System.out.println("Process Q waits Wantp false");
			Thread.sleep((long) 1000);
			if(!controller.isWantp()) {
				System.out.println("Process Q on critical section");
				Thread.sleep((long) 1000);
				System.out.println("Process Q leaves the critical section");
				Thread.sleep((long) 1000);
				System.out.println("Process Q set Wantq false");
				controller.setWantq(false);
			}
			Thread.sleep((long) 1000);
		}
	}
	@Override
	public void run() {
		try {
			myProcess();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
