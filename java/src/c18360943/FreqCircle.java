package c18360943;

public class FreqCircle extends Visuals {
	Circles c;
	
	public FreqCircle(Circles c) {
		this.c=c;
	}
	
	public void render() {
		this.c.stroke((int)(c.hue * 0.8),360, 360);
		this.c.strokeWeight(3);
		//circle mapping the frequency of the audio
		for(int i = 0 ; i<c.getBands().length ; i++) {
			c.freqHist.add(c.getSmoothenedBands()[i]);
			if(c.freqHist.size() == 512) { //only include 512 bands at a time.
				c.freqHist.removeFirst(); //only remove first element so circle doesn't restart
			}
		}
		c.beginShape();
		for(int i = 0; i<c.freqHist.size();i++) {
			float angle = map(i,0,c.freqHist.size(),0,360);	
			float amp = c.freqHist.get(i);
			float r = map(amp, 0, 256, 40, 200);
			float x = r * cos(angle);
			float y = r * sin(angle);
			c.vertex(x,y);
		}
		c.endShape();
	}
}
