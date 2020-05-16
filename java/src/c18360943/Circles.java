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
	LinkedList<Float> bandsHist = new LinkedList();
	boolean top=false;
	
	public void settings() {
		size(screenWidth, screenHeight);
	}
	
	public void setup() {
		colorMode(HSB);
		backgroundImage = loadImage(bGround);
		startMinim();
		loadAudio("TheRealm.mp3");
		getAudioPlayer().play();
	}
	
	public void draw() {
		calculateFFT();
		calculateAverageAmplitude();
		calculateFrequencyBands();
		background(backgroundImage);
		colorMode(HSB);
		history.add(getSmoothenedAmplitude());
		for(int i = 0 ; i< getBands().length ; i++) {
			bandsHist.add(getSmoothenedBands()[i]);
			if(bandsHist.size() == screenWidth/2) {
				bandsHist.clear();
			}
		}
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
		stroke(255);
		for(int i=0;i<bandsHist.size();i++) {
			float y = map(bandsHist.get(i), 0, 512, screenHeight/2, 0);
			if(top==false) {
				vertex(i,y);
				stroke(hue, 255, 255);
			}
			else {
				vertex(-i,-y);
			}
		}
		if(bandsHist.size() == 1) {
			bandsHist.clear();
		}
		endShape();
		
		//Amplitude visualizer mirror
		beginShape();
		for(int i=0;i<bandsHist.size();i++) {
			float y = map(bandsHist.get(i), 0, 512, screenHeight/2, 0);
			if(top==false) {
				stroke(hue, 255 ,255);
				vertex((-i),y);
			}
			else {
				vertex(i,-y);
			}
		}
				endShape();
	}
	
	void createCircles() {
		//outter circle
		beginShape();
		for(int i = 0; i<360;i++) {
			float radius = map(getSmoothenedAmplitude(), 0, 1, 10, 200);
			float x = radius * cos(i) * 3;
			float y = radius * sin(i) * 4;
			vertex(x,y);
		}
		endShape();
		
		//inner circle 
		beginShape();
		for(int i = 0; i<360 ; i++){
			float radius = map(getSmoothenedAmplitude() , 0 , 1 , 10 , 100);
			float x = radius * cos(i) * 2;
			float y = radius * sin(i) * 2;
			vertex(x,y);
		}
		endShape();
		
		beginShape();
		stroke(255);
		ellipse(0 ,0 ,screenWidth , getSmoothenedAmplitude() * 3000);
		endShape();
	}
}
