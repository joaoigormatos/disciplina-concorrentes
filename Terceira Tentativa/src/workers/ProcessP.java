package workers;

import main.Controller;

public class ProcessP  extends Thread{
	Controller controller = Controller.getInstance();
	private void myProcess() throws InterruptedException {
		
		while(true) {
			System.out.println("Process P on non-critical section");
			Thread.sleep((long) 1000);
			System.out.println("Process P set Wantp true");
			controller.setWantp(true);
			Thread.sleep((long) 1000);
			System.out.println("Process P waits Wantq false");
			Thread.sleep((long) 1000);
			if(!controller.isWantq()) {
				System.out.println("Process P on critical section");
				Thread.sleep((long) 1000);
				System.out.println("Process P leaves the critical section");
				Thread.sleep((long) 1000);
				System.out.println("Process P set Wantp false");
				controller.setWantp(false);
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
