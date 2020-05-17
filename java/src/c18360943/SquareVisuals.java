package c18360943;

public class SquareVisuals extends Visuals {
	Circles c;
	
	public SquareVisuals(Circles c) {
		this.c=c;
	}
	
	public void render() {
		//Lines to give the impression of being in a cube 
		this.c.stroke((int)(c.hue), 360,360);
		c.beginShape();
		this.c.translate(0,0);
		c.quad(-450,250,450,250,450,-250,-450,-250);  //Rectanglem in center  of screen
		
		//lines going from the corners to the rectangle edges to give a cube effect
		c.line(-c.screenWidth/2, -c.screenHeight/2, -450,-250);
		c.line(c.screenWidth/2, c.screenHeight/2, 450,250);
		c.line(-c.screenWidth/2, c.screenHeight/2, -450,250);
		c.line(c.screenWidth/2, -c.screenHeight/2, 450,-250);
		c.endShape();
	}
}
