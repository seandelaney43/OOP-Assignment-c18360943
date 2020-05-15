package c18360943;


public class Main { //OOP Project

	public static void main(String[] args) {
		
		Main main = new Main();
		Visuals visual = new Visuals();
		main.startApp();
	}
	
	public void startApp() {
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new Circles());
	}

}
