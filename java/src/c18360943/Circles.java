package c18360943;

import java.util.LinkedList;

import processing.core.PImage;

public class Circles extends Visuals {
	int screenWidth = 1024; //screenWidth and screenHeight are set to the dimensions  of the photo that I am using for my background
	int screenHeight = 775;
	private PImage backgroundImage;
	private String bGround = "Realm.jpg";
	private float hue;
	LinkedList<Float> history = new LinkedList();
	boolean top=false;
	
	public void settings() {
		size(screenWidth, screenHeight);
	}
	
	public void setup() {
		colorMode(HSB);
		backgroundImage = loadImage(bGround);
		startMinim();
		loadAudio("heroplanet.mp3");
		getAudioPlayer().play();
	}
	
	public void draw() {
		calculateAverageAmplitude();
		calculateFrequencyBands();
		background(backgroundImage);
		colorMode(HSB);
		history.add(getSmoothenedAmplitude());
		hue = map(getSmoothenedAmplitude() * 1000, -400, 300, 0 ,255);
		stroke(hue, 255, 255);
		noFill();
		translate(screenWidth/2 , screenHeight/2);
		Visualiser();
		createCircles();
	}
	
	
	public void keyPressed() //Functional keys for playing and pausing the audio
    {
        if (key == ' ')
        {
            if(getAudioPlayer().isPlaying()) {
            	getAudioPlayer().pause();
            }
            else {
            	getAudioPlayer().play();
            }
        }
        if(key == 't') {
        	if(top==false) {
        		top=true;
        	}
        	else {
        		top=false;
        	}
        }
    }
	
	void Visualiser() {
		//Amplitude visualizer at the bottom/top of the screen
		beginShape();
		for(int i=0;i<history.size();i++) {
			float y = map(history.get(i), 0, 1, screenHeight/2, 0);
			if(top==false) {
				vertex(i,y);
			}
			else {
				vertex(-i,-y);
			}
		}
		if(history.size()==screenWidth/2) {
			history.clear();
		}
		endShape();
		
				//Amplitude visualizer mirror
		beginShape();
		for(int i=0;i<history.size();i++) {
			float y = map(history.get(i), 0, 1, screenHeight/2, 0);
			if(top==false) {
				vertex((-i),y);
			}
			else {
				vertex(i,-y);
			}
		}
				endShape();
	}
	
	void createCircles() {
		beginShape();
		for(int i = 0; i<360;i++) {
			float radius = map(getSmoothenedAmplitude(), 0, 1, 10, 500);
			float x = radius * cos(i);
			float y = radius * sin(i);
			vertex(x,y);
		}
		endShape();
		beginShape();
		for(int i = 0; i<360 ; i++){
			float radius = map(getSmoothenedAmplitude() , 0 , 1 , 10 , 100);
			float x = radius * cos(i) * 4;
			float y = radius * sin(i) * 4;
			vertex(x,y);
		}
		endShape();
	}
}
