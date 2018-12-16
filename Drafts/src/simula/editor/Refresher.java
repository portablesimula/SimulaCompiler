package simula.editor;

public class Refresher extends Thread {
	boolean stop=false;
	
	public Refresher() {
		setPriority(MIN_PRIORITY);
		while(!stop) {
			try {sleep(100); } catch(InterruptedException e) {}
			if(SourceTextPane.refreshNeeded) {
				SourceTextPane.refreshNeeded=false;
			}
		}
	}
	
}
