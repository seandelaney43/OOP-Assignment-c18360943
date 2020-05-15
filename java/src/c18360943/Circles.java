package c18360943;

import static processing.core.PApplet.map;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PImage;

public class Circles extends Visuals {
	private int screenWidth = 1024;
	private int screenHeight = 775;
	int circleCount = 10;
	Circle[] circles = new Circle[circleCount];
	PImage backgroundImage;
	String bGround = "Realm.jpg";
	
	public void settings() {
		size(screenWidth, screenHeight);
	}
	
	public void setup() {
		colorMode(HSB);
		backgroundImage = loadImage(bGround);
		startMinim();
		loadAudio("TheRealm.mp3");
		getAudioPlayer().play();
		startListening();
		
		for(int i = 0; i < circles.length; i++){
            circles[i] = new Circle(this);
            circles[i].speed = random(1, 3);
            circles[i].angle = random(360);
            circles[i].roundRadius = random(20, height/8);
            circles[i].radius = random(18, height/30);
            circles[i].fillCircle = 1;
        }
	}
	
	public void draw() {
		background(backgroundImage);
		calculateAverageAmplitude();
	}
}
