package workers;

import main.Controller;

public class ProcessP  extends Thread{
	Controller controller = Controller.getInstance();
	public ProcessP() {}
	
	private void myProcess() throws InterruptedException {
		while(true) {
			System.out.println("Process P on the non-critical section");
			Thread.sleep((long) 1000);
			controller.setWantp(true);
			System.out.println("Process P set wantp true");
			Thread.sleep((long) 1000);
			while(controller.isWantq()) {
				controller.setWantp(false);
				System.out.println("Process P set wantp false");
				Thread.sleep((long) 1000);
				controller.setWantp(true);
				System.out.println("Process P set wantp true");
				Thread.sleep((long) 1000);
			}
			System.out.println("Process P on the critical section");
			Thread.sleep((long) 1000);
			System.out.println("Process P leaves the critical section");
			Thread.sleep((long) 1000);
			controller.setWantp(false);
			System.out.println("Process P set wantp false");
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
