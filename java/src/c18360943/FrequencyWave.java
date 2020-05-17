package c18360943;

public class FrequencyWave extends Visuals {
	Circles c;
	
	public FrequencyWave(Circles c) {
		this.c=c;
	}
	
	public void render() {
		this.c.stroke((int)(c.hue*1.4), 360 , 360);
		c.beginShape();
		for(int i=0;i<c.bandsHist.size();i++) {
			float y = map(c.bandsHist.get(i), 0, 1024, 0, c.screenHeight/4); 
			c.vertex(i,y); //vertex from i to the frequency value with a max height of 1'4 the screen height 
		}
		c.endShape();
		
		c.beginShape();
		for(int i=0;i<c.bandsHist.size();i++) {
			float y = map(c.bandsHist.get(i), 0, 1024, 0, c.screenHeight/4);
			c.vertex(i, -y); //vertex from i to the frequency value with a max height of 1'4 the screen height 
		}
		c.endShape();
		
		c.beginShape();
		for(int i=0;i<c.bandsHist.size();i++) {
			float y = map(c.bandsHist.get(i), 0, 1024, 0, c.screenHeight/4);
			c.vertex(-i, y); //vertex from i to the frequency value with a max height of 1'4 the screen height 
		}
		c.endShape();
		
		c.beginShape();
		for(int i=0;i<c.bandsHist.size();i++) {
			float y = map(c.bandsHist.get(i), 0, 1024, 0, c.screenHeight/4);
			c.vertex(-i, -y); //vertex from i to the frequency value with a max height of 1'4 the screen height 
		}
		c.endShape();
	}
}
