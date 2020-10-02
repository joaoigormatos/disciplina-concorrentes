package main;

import workers.ProcessP;
import workers.ProcessQ;

public class Main {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		
		ProcessP processP = new ProcessP();
		ProcessQ processQ = new ProcessQ();
		
		processP.start();
		processQ.start();
	}

}
