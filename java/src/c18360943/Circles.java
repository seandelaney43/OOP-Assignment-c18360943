package c18360943;

import java.util.LinkedList;

import processing.core.PImage;

public class Circles extends Visuals {
	private int screenWidth = 1024; //screenWidth and screenHeight are set to the dimensions  of the photo that I am using for my background
	private int screenHeight = 775;
	int circleCount = 10; //number of circles to be displayed
	Circle[] circles = new Circle[circleCount];
	private PImage backgroundImage;
	private String bGround = "Realm.jpg";
	
	public void settings() {
		size(screenWidth, screenHeight);
	}
	
	public void keyPressed() //Functional keys for playing and pausing the audio
    {
        if (key == ' ')
        {
            getAudioPlayer().play();
            
        }
        if(key == 'p') {
        	getAudioPlayer().pause();
        }
    }
	
	public void setup() {
		colorMode(HSB);
		backgroundImage = loadImage(bGround);
		startMinim();
		loadAudio("TheRealm.mp3");
		getAudioPlayer().play();
		startListening();
	}
	
	public void draw() {
		calculateAverageAmplitude();
		LinkedList<Float> list = new LinkedList();
		for(int i = 0; i < 360; i++) {
			list.add(getSmoothenedAmplitude());
		}
		calculateFrequencyBands();
		background(backgroundImage);
		colorMode(HSB);
		stroke(255);
		noFill();
		translate(screenWidth/2 , screenHeight/2);
		beginShape();
		for(int i = 0; i<360; i++) {
			float r = map(list.get(i) , 0 , 1, 10, 400);
			float x= r * cos(i) * 2;
			float y = r * sin(i) * 2;
	
			vertex(x,y);
		}
		endShape();
		beginShape();
		for(int i = 0; i<360; i++) {
				float k = map(getSmoothenedAmplitude(), 0 , 1 , 10, 500);
				float t = k * cos(i); 
				float j = k * sin(i);
			
			vertex(t,j);
		}
		endShape();
		beginShape();
		for(int i = 0 ; i<360; i++) {
			float r = map(getSmoothenedAmplitude(), 0, 1, 10, 100);
			float x = r * cos(i) * 4;
			float y = r * sin(i) * 4; 
			
			vertex (x,y);
		}
		endShape();
		beginShape();
		stroke(250);
		ellipse(0 ,0 ,screenWidth , getSmoothenedAmplitude() * 2000);
		endShape();
			
	}
}
