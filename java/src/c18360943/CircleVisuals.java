package c18360943;

import processing.core.*;
import processing.core.PApplet;

public class CircleVisuals extends Visuals{
	Circles c;
	int width;
	
	public CircleVisuals(Circles c) {
		this.c = c;
		width = this.c.screenWidth;
	}
	
	public void render() {
			//outter circle
			c.beginShape();
			for(int i = 0; i<360;i++) {
				float radius = map(c.getSmoothenedAmplitude(), 0, 1, 10, 200); //Radius moves with the amplitude
				float x = radius * cos(i) * 3; //different x and y multiplices to make an oval shape
				float y = radius *sin(i) * 4;
				c.vertex(x, y);
			}
			c.endShape();
			
			//inner circle 
			 c.beginShape();
			 for(int i = 0; i<360 ; i++){
				 float radius = map(c.getSmoothenedAmplitude() , 0 , 1 , 10 , 100); //radius moving with amplitude measured to a smaller volume
				 float x = radius * cos(i) * 2;
				 float y = radius * sin(i) * 2;
				 c.vertex(x,y);
			}
			c.endShape();
			
			c.beginShape();
			this.c.stroke((int)(c.hue * 1.3), 360, 360);
			c.ellipse(0,0, width ,100 + c.getSmoothenedAmplitude()*3000); //ellipse the full with of the screen which contains the circles and also moves with the songs amplitude
			c.endShape();
	}

}
