package main;

public class Controller {
	
	private boolean wantp;
	private boolean wantq;
	
	private static Controller instance;
	private Controller() {
		wantp= false;
		wantq = false;
	}
	
	public static Controller getInstance() {
		if(instance==null) instance = new Controller();
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
