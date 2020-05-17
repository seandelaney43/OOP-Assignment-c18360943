package c18360943;

public class AmplitudeWaves extends Visuals{
	Circles c;
	
	public AmplitudeWaves(Circles c){
		this.c = c;
	}
	
	void render() {
		//Amplitude visualizer at the bottom/top of the screen
		c.beginShape();
		for(int i=0;i<c.ampHistory.size();i++) {
			float y = map(c.ampHistory.get(i), 0, 1, c.screenHeight/2, 0); //map all amplitudes 
			if(c.top == false) {
				c.vertex(i,y); //if user has selected visuals to be at bottom of screen
			}
			else {
				c.vertex(-i,-y); //visuals inverted at top of the screen
			}
		}
		c.endShape();
		
		c.beginShape();
		for(int i=0;i<c.ampHistory.size();i++) {
			float y = map(c.ampHistory.get(i), 0, 1, c.screenHeight/2, 0); //map amplitudes
			if(c.top == false) { 
				c.vertex(-i,y); //visuals at bottom of the screen that mirror the right hand side
			}
			else {
				c.vertex(i,-y); //visuals at top of screen as a mirror.
			}
		}
		c.endShape();
	}
}
	
