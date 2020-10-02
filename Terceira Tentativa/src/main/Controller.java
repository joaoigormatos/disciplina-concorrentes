package main;

public class Controller {
	private static Controller instance;
	private boolean wantp;
	private boolean wantq;
	
	private Controller() {
		this.wantp = false;
		this.wantq = false;
	}
	
	public static Controller getInstance() {
		if(instance==null) {
			instance = new Controller();
		}
		return instance;
	}

	public boolean isWantp() {
		return wantp;
	}

	public void setWantp(boolean wantp) {
		this.wantp = wantp;
	}

	public boolean isWantq() {
		return wantq;
	}

	public void setWantq(boolean wantq) {
		this.wantq = wantq;
	}
	
	
}
